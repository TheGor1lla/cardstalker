package de.gor1lla.cardstalker.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Card implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String mailAddress;
    private float currentPrice;
    private float maxNotificationPrice;
    private int locale;
    private Character foil;
    private String cardId;

    public Card(String url, String mailAddress, float currentPrice, float maxNotificationPrice, int locale, Character foil, String cardId) {
        this.url = url;
        this.mailAddress = mailAddress;
        this.currentPrice = currentPrice;
        this.maxNotificationPrice = maxNotificationPrice;
        this.locale = locale;
        this.foil = foil;
        this.cardId = cardId;
    }
}
