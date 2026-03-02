package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListClasseResponse {
    private String nom;
    private String prenom;
    private String matricule;
    private String sexe;
    private Integer age;
    private String dateNaissance;
    private String lieuNaissance;
    private String nationalite;
    private String telephone;
    private String photo;
    private String filiere;
    private String statut;
}
