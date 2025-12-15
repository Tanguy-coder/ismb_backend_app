package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DomainNote extends AbstractEntity {
    private DomainEtudiant etudiant;
    private DomainUe ue;
    private DomainFiliere filiere;
    private Float cc;
    private Float tp;
    private Float examen;
    private Float moyenne;
    private String session;
    private DomainAnneeScolaire anneeScolaire;
    private Integer periode;
    private String mention;
    private Integer moyCoef;

}
