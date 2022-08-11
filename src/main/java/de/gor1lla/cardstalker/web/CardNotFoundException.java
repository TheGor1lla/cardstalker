package de.gor1lla.cardstalker.web;

public class CardNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1521719523L;

    public CardNotFoundException(String stalkCode) {

        super(String.format("Card not found: %s", stalkCode));
    }
}
