package de.gor1lla.cardstalker.web;

import de.gor1lla.cardstalker.domain.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
class WebController {

    private final CardManagementService cardManagementService;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    public WebController(CardManagementService cardManagementServiceImpl) {
        this.cardManagementService = cardManagementServiceImpl;
    }

    @GetMapping
    public String getCardForm(Model model, HttpSession session) {

        model.addAttribute("card", new Card());
        model.addAttribute("keepLocale", session.getAttribute("keepLocale"));
        model.addAttribute("keepMail", session.getAttribute("keepMail"));
        return "form";
    }

    @PostMapping
    public String addCard(@ModelAttribute Card card, HttpSession session, BindingResult result, RedirectAttributes redirectAttributes) {

        session.setAttribute("keepLocale", card.getLocale());
        session.setAttribute("keepMail", card.getMailAddress());

        if (!card.getUrl().matches("^http(s)?\\:\\/\\/(www)?\\.cardmarket\\.(net|com)\\/.*")) {
            FieldError error = new FieldError("card", "url", "Not a cardmarket link");
            result.addError(error);
            return "form";
        }
        String stalkCode = cardManagementService.saveCard(card);

        redirectAttributes.addFlashAttribute("stalkCode", stalkCode);
        return "redirect:/";
    }

    // ToDo: authorization
    @GetMapping(value = "/cards")
    public String listAllCards(Model model) {

        List<Card> cards;
        cards = cardManagementService.getAllCards();

        model.addAttribute("allCards", cards);

        return "card_list";
    }

    @GetMapping(value = "/details/{stalkCode}")
    public String showCardDetails(Model model, @PathVariable String stalkCode) {

        Card card = cardManagementService.getCardByStalkCode(stalkCode);
        model.addAttribute("card", card);

        return "card_details";
    }

    @GetMapping(value = "/delete/{stalkCode}")
    public String deleteCard(@PathVariable String stalkCode) {

        cardManagementService.deleteByStalkCode(stalkCode);

        return "redirect:/cards";


    }
}
