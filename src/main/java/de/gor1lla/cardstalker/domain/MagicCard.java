package de.gor1lla.cardstalker.domain;

public class MagicCard extends Card {

    private Character foil;

    @Override
    public Character getFoil() {
        return foil;
    }

    @Override
    public void setFoil(Character foil) {
        this.foil = foil;
    }
}
