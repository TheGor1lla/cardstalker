package de.gor1lla.cardstalker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
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

    public Card() {
    }

    public Card(String url, String mailAddress, float currentPrice, float maxNotificationPrice, int locale, Character foil, String cardId) {
        this.url = url;
        this.mailAddress = mailAddress;
        this.currentPrice = currentPrice;
        this.maxNotificationPrice = maxNotificationPrice;
        this.locale = locale;
        this.foil = foil;
        this.cardId = cardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getMaxNotificationPrice() {
        return maxNotificationPrice;
    }

    public void setMaxNotificationPrice(float maxNotificationPrice) {
        this.maxNotificationPrice = maxNotificationPrice;
    }

    public int getLocale() {
        return locale;
    }

    public void setLocale(int locale) {
        this.locale = locale;
    }

    public Character getFoil() {
        return foil;
    }

    public void setFoil(Character foil) {
        this.foil = foil;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", currentPrice=" + currentPrice +
                ", maxNotificationPrice=" + maxNotificationPrice +
                ", locale=" + locale +
                ", foil=" + foil +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
