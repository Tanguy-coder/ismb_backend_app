package com.tanguydev.ismb.Infrastructure.Request;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EtudiantRequest {
    // User fields
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private Set<DomainRole> roles; // Assuming roles are sent as DomainRole objects or similar
    private String contact; // Added contact field

    private String sexe;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String telephone;
    private String nationalite;
    private FiliereRequest filiere; // Changed to FiliereRequest object
    private String attentes;
    private String statut; // For ParcourtEtudiant
}
