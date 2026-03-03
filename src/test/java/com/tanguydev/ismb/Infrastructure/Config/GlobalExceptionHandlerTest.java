package com.tanguydev.ismb.Infrastructure.Config;

import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Domain.Exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void whenResourceNotFoundException_shouldReturnFrenchMessage() throws Exception {
        mockMvc.perform(get("/test/resource-not-found"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("Ressource non trouvée")))
                .andExpect(jsonPath("$.message", is("Objet test non trouvé")));
    }

    @Test
    @WithMockUser
    void whenDuplicateMatriculeException_shouldReturnSpecificMessage() throws Exception {
        mockMvc.perform(get("/test/duplicate-matricule"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error", is("Conflit de données")))
                .andExpect(jsonPath("$.message", is("Ce matricule est déjà utilisé par un autre étudiant")));
    }

    @Test
    @WithMockUser
    void whenDuplicateUsernameException_shouldReturnSpecificMessage() throws Exception {
        mockMvc.perform(get("/test/duplicate-username"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error", is("Conflit de données")))
                .andExpect(jsonPath("$.message", is("Ce nom d'utilisateur est déjà utilisé")));
    }

    @Test
    @WithMockUser
    void whenDuplicateEmailException_shouldReturnSpecificMessage() throws Exception {
        mockMvc.perform(get("/test/duplicate-email"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error", is("Conflit de données")))
                .andExpect(jsonPath("$.message", is("Cette adresse email est déjà utilisée")));
    }

    @Test
    @WithMockUser
    void whenDuplicateFiliereException_shouldReturnSpecificMessage() throws Exception {
        mockMvc.perform(get("/test/duplicate-filiere"))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.error", is("Conflit de données")))
                .andExpect(jsonPath("$.message", is("Ce libellé de filière est déjà utilisé")));
    }

    @RestController
    static class TestController {
        @GetMapping("/test/resource-not-found")
        public void throwResourceNotFound() {
            throw new ResourceNotFoundException("Objet test non trouvé");
        }

        @GetMapping("/test/duplicate-matricule")
        public void throwDuplicateMatricule() {
            throw new DuplicateResourceException("Etudiant", "matricule", "ETU20261");
        }

        @GetMapping("/test/duplicate-username")
        public void throwDuplicateUsername() {
            throw new DuplicateResourceException("User", "username", "testuser");
        }

        @GetMapping("/test/duplicate-email")
        public void throwDuplicateEmail() {
            throw new DuplicateResourceException("User", "email", "test@example.com");
        }

        @GetMapping("/test/duplicate-filiere")
        public void throwDuplicateFiliere() {
            throw new DuplicateResourceException("Filiere", "libellé", "Informatique");
        }
    }
}
