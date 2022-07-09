package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;

import java.util.List;

public interface CardManagementService {

    List<Card> getAllCards();

    Card getCardByStalkCode(String stalkCode);

    void deleteByStalkCode(String stalkCode);

    void saveCard(Card card);
}
