package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import de.gor1lla.cardstalker.repositories.CardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class WebController {

    private final CardRepository cardRepository;
    private final CardService cardService;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    public WebController(CardRepository cardRepository, CardService cardService) {
        this.cardRepository = cardRepository;
        this.cardService = cardService;
    }

    @GetMapping
    public String getCardForm(Model model) {

        model.addAttribute("card", new Card());
        return "form";
    }

    @PostMapping
    public String addCard(@ModelAttribute Card card) {

        card.setUuid(UUID.randomUUID().toString());
        cardRepository.save(card);
        LOGGER.info("Received new card {}", card);
        return "form";
    }

    @GetMapping(value = "/cards")
    public String listAllCards(Model model) {

        List<Card> cards;
        cards = cardRepository.findAll();

        model.addAttribute("allCards", cards);

        return "card_list";
    }

    //TODO: form clear
    @GetMapping(value = "/details/{cardId}")
    public String showCardDetails(Model model, @PathVariable String cardId) {

        Card card = cardRepository.findByUUID(cardId);
        model.addAttribute("card", card);

        return "card_details";
    }

    @GetMapping(value = "/delete/{cardId}")
    public String deleteCard(@PathVariable String cardId) {

        cardRepository.deleteByUUID(cardId);
        LOGGER.info("Deleted card: {}", cardId);

        return "redirect:/cards";


    }
}
