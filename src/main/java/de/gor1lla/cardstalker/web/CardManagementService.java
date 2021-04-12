package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;

import java.util.List;

public interface CardManagementService {

    List<Card> getAllCards();

    Card getCardByCardId(String cardId);

    void deleteByCardId(String cardId);

    void saveCard(Card card);
}
