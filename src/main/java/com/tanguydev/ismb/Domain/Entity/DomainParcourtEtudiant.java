package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainParcourtEtudiant extends AbstractEntity {
    private DomainEtudiant etudiant;
    private DomainAnneeScolaire anneeScolaire;
    private DomainFiliere filiere;
    private String statut;

}
