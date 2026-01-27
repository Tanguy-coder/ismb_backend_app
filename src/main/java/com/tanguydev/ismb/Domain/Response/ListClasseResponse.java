package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListClasseResponse {
    private String nom;
    private String prenom;
    private String sexe;
    private Integer age;
    private String lieuNaissance;
    private String nationalite;
    private String photo;
    private String filiere;
    private String statut;
}
