package com.tanguydev.ismb.Infrastructure.Request;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class EtudiantRequest {

    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String password;
    private Set<DomainRole> roles;
    private String contact;
    private String sexe;
    private String matricule;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String telephone;
    private String nationalite;
    private FiliereRequest filiere;
    private String attentes;
    private String statut;
}
