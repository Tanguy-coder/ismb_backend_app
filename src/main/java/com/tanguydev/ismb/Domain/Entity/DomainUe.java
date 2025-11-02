package com.tanguydev.ismb.Domain.Entity;

import java.util.Set;

public class DomainUe extends AbstractEntity {
    private String libelle;
    private String semestre;
    private DomainFiliere filiere;
    private Integer volumeHoraire;
    private Set<DomainNote> notes;


}
