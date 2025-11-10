package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEnseignant extends AbstractEntity {
    private DomainUser user;
    private String sexe;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String telephone;
    private String nationalite;
    private String photo;
    private String matiere;
}
