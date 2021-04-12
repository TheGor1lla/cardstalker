package de.gor1lla.cardstalker.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String mailAddress;
    private float currentPrice;
    private float maxNotificationPrice;
    private int locale;
    private Character foil;
    private String uuid;

    public Card() {

    }

    public Card(String url, String mailAddress, float currentPrice, float maxNotificationPrice, int locale, Character foil, String uuid) {
        this.url = url;
        this.mailAddress = mailAddress;
        this.currentPrice = currentPrice;
        this.maxNotificationPrice = maxNotificationPrice;
        this.locale = locale;
        this.foil = foil;
        this.uuid = uuid;
    }
}
