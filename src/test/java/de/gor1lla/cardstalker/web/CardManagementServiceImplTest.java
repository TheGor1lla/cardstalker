package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardEntity;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CardManagementServiceImplTest {

    public static final String CARD_URL = "https://www.cardmarket.com/en/Magic/Products/Singles/Morningtide/Thornbite-Staff";
    public static final String MAIL = "test@example.org";

    List<CardEntity> cardEntityList = Arrays.asList(
            new CardEntity(CARD_URL, MAIL, 1f, 0.1f, 3, 'Y', "abc-def"),
            new CardEntity(CARD_URL, MAIL, 10f, 200f, 1, 'Y', "def-abc")
    );

    List<Card> cardList = Arrays.asList(
            new Card(CARD_URL, MAIL, 1f, 0.1f, 3, 'Y', "abc-def"),
            new Card(CARD_URL, MAIL, 10f, 200f, 1, 'Y', "def-abc")
    );


    @InjectMocks
    CardManagementServiceImpl cardManagementService;

    @Mock
    CardRepository cardRepository;

    @Spy
    ModelMapper modelMapper;

    @BeforeAll
    static void setup() {

    }

    @Test
    void ensureGetAllCardsReturnsCorrectDomainObjects() {

        when(cardRepository.findAll()).thenReturn(cardEntityList);

        List<Card> allCards = cardManagementService.getAllCards();

        assertThat(cardList).usingRecursiveComparison().isEqualTo(allCards);
    }

    @Test
    void ensureNotFindingCardThrowsException() {
        Throwable exception = assertThrows(CardNotFoundException.class, () -> cardManagementService.getCardByStalkCode("def-def"));
        assertEquals("Card not found: def-def", exception.getMessage());
    }
}
