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

        if(cardRepository.findAll().size() == 0) {
            List<Card> cardList = new ArrayList<>();
            cardList.add(new Card("url1", "mail@example.org", 1.2f, 12.2f, 1, 'Y', UUID.randomUUID().toString()));
            cardList.add(new Card("url2", "mail@example.net", 1.2f, 1.2f, 1, 'Y', UUID.randomUUID().toString()));
            cardList.add(new Card("url3", "mail@example.com", 1.2f, 1, 1, 'N', UUID.randomUUID().toString()));
            cardList.add(new Card("url4", "mail@example.de", 1.2f, 1.2f, 1, 'N', UUID.randomUUID().toString()));
            cardRepository.saveAll(cardList);
        }
    }
}
