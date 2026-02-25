package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String contact;
    private String sexe;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String nationalite;
    private String photo;
    private String matiere;
    private boolean etat;
}
