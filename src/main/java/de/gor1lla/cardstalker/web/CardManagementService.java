package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;

import java.util.List;

interface CardManagementService {

    List<Card> getAllCards();

    Card getCardByStalkCode(String stalkCode);

    void deleteByStalkCode(String stalkCode);

    String saveCard(Card card);
}
