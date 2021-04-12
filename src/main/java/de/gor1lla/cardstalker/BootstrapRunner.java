package de.gor1lla.cardstalker;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BootstrapRunner implements CommandLineRunner {

    private final CardRepository cardRepository;

    public BootstrapRunner(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Card> cardList = new ArrayList<>();
        cardList.add(new Card("url1", "mail@",1.2f,1.2f,1,'Y', UUID.randomUUID().toString()));
        cardList.add(new Card("url2", "mail@",1.2f,1.2f,1,'Y', UUID.randomUUID().toString()));
        cardList.add(new Card("url3", "mail@",1.2f,1.2f,1,'Y', UUID.randomUUID().toString()));
        cardList.add(new Card("url4", "mail@",1.2f,1.2f,1,'Y', UUID.randomUUID().toString()));
        cardRepository.saveAll(cardList);
    }
}
