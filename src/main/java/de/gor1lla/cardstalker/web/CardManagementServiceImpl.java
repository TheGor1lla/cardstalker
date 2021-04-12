package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardManagementServiceImpl implements CardManagementService {

    private final CardRepository cardRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(CardManagementServiceImpl.class);


    public CardManagementServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCardByCardId(String cardId) {
        return cardRepository.findByCardId(cardId);
    }

    @Override
    public void deleteByCardId(String cardId) {
        cardRepository.deleteByCardId(cardId);
        LOGGER.info("Deleted card: {}", cardId);
    }

    @Override
    public void saveCard(Card card) {

        card.setCardId(UUID.randomUUID().toString());
        cardRepository.save(card);
        LOGGER.info("Saved new card {}", card);
    }
}
