package com.tanguydev.ismb.Domain.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DomainUe extends AbstractEntity {
    private String libelle;
    private Integer credits;
    private String code;
    private DomainFiliere filiere;
    private Integer volumeHoraire;
    private Set<DomainNote> notes;
    private DomainMatiere matiere;
    private DomainEnseignant enseignant;
    private DomainAnneeScolaire anneeScolaire;
}
