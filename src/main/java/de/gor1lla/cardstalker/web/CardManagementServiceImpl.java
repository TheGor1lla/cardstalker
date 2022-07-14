package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardEntity;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class CardManagementServiceImpl implements CardManagementService {

    private final ModelMapper modelMapper;
    private final CardRepository cardRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CardManagementServiceImpl.class);


    CardManagementServiceImpl(CardRepository cardRepository, ModelMapper modelMapper) {
        this.cardRepository = cardRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Card> getAllCards() {
        return Arrays.asList(modelMapper.map(cardRepository.findAll(), Card[].class));
    }

    @Override
    public Card getCardByStalkCode(String stalkCode) {
        // ToDO Does Mapping work with ObjectMapper
        return modelMapper.map(cardRepository.findByStalkCode(stalkCode)
                .orElseThrow(() -> new CardNotFoundException(stalkCode)), Card.class);
    }

    @Override
    public void deleteByStalkCode(String stalkCode) {

        cardRepository.deleteByStalkCode(stalkCode);
        LOGGER.info("Deleted card: {}", stalkCode);
    }

    @Override
    public String saveCard(Card card) {

        buildUrlForCard(card);

        card.setStalkCode(UUID.randomUUID().toString());
        CardEntity savedCard = cardRepository.save(modelMapper.map(card, CardEntity.class));

        LOGGER.info("Saved new card {}", savedCard);

        return savedCard.getStalkCode();
    }

    private void buildUrlForCard(Card card) {

        String completeUrl = UriComponentsBuilder
                .fromUriString(card.getUrl().split(("\\?|\\#"))[0]) // remove all params
                .queryParam("language", card.getLocale())
                .queryParamIfPresent("isFoil", Optional.ofNullable(card.getFoil()))
                .build()
                .toUriString();
        card.setUrl(completeUrl);
    }
}
