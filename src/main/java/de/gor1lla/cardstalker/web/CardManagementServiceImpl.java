package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardEntity;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    private final ModelMapper modelMapper;
    private final CardRepository cardRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CardManagementServiceImpl.class);


    public CardManagementServiceImpl(CardRepository cardRepository, ModelMapper modelMapper) {
        this.cardRepository = cardRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Card> getAllCards() {
        return Arrays.asList(modelMapper.map(cardRepository.findAll(), Card[].class));
    }

    @Override
    public Card getCardByStalkCode(String stalkCode) {

        return modelMapper.map(cardRepository.findByStalkCode(stalkCode), Card.class);
    }

    @Override
    public void deleteByStalkCode(String stalkCode) {

        cardRepository.deleteByStalkCode(stalkCode);
        LOGGER.info("Deleted card: {}", stalkCode);
    }

    @Override
    public void saveCard(Card card) {

        card.setStalkCode(UUID.randomUUID().toString());
        CardEntity savedCard = cardRepository.save(modelMapper.map(card, CardEntity.class));

        LOGGER.info("Saved new card {}", savedCard);
    }
}
