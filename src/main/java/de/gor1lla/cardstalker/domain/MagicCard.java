package de.gor1lla.cardstalker.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class MagicCard extends Card {

    private Character foil;
}
