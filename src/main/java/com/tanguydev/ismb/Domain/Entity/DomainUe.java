package com.tanguydev.ismb.Domain.Entity;

import java.util.Set;

public class DomainUe extends AbstractEntity {
    private String libelle;
    private String semestre;
    private DomainNiveau niveau;
    private Integer volumeHoraire;
    private Set<DomainNote> notes;

    public DomainUe() {}

    public DomainUe(String libelle, String semestre, DomainNiveau niveau, Integer volumeHoraire) {
        this.libelle = libelle;
        this.semestre = semestre;
        this.niveau = niveau;
        this.volumeHoraire = volumeHoraire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public DomainNiveau getNiveau() {
        return niveau;
    }

    public void setNiveau(DomainNiveau niveau) {
        this.niveau = niveau;
    }

    public Integer getVolumeHoraire() {
        return volumeHoraire;
    }

    public void setVolumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public Set<DomainNote> getNotes() {
        return notes;
    }

    public void setNotes(Set<DomainNote> notes) {
        this.notes = notes;
    }
}
