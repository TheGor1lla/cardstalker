package de.gor1lla.cardstalker.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = WebController.class)
@ExtendWith(SpringExtension.class)
class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardManagementService cardManagementService;

    @Test
    void ensureRootCallReturnsCardForm() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("form"));
    }

    @Test
    void ensureOnlyValidCardmarketLinksWork() throws Exception {

        mockMvc.perform(post("/")
                        .param("url", "https://www.cardmarket.com/en/Magic/Products/Singles/Morningtide/Thornbite-Staff")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(model().hasNoErrors());

        mockMvc.perform(post("/")
                        .param("url", "https://www.google.de/")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
    }

    @Test
    void ensureErrorOnUnauthenticatedRequestsForCardList() throws Exception {
        mockMvc.perform(get("/cards"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void ensureOnlyAuthenticatedRequestsForCardList() throws Exception {
        mockMvc.perform(get("/cards"))
                .andExpect(status().isOk())
                .andExpect(model().hasNoErrors());
    }
}
