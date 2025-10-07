package com.tanguydev.ismb.Domain.Entity;

public class DomainParcourtEtudiant extends AbstractEntity {
    private DomainEtudiant etudiant;
    private DomainAnneeScolaire anneeScolaire;
    private DomainNiveau niveau;
    private Integer statut; // nouveau, redoublant, etc.

    public DomainParcourtEtudiant() {}

    public DomainParcourtEtudiant(DomainEtudiant etudiant, DomainAnneeScolaire anneeScolaire, DomainNiveau niveau, Integer statut) {
        this.etudiant = etudiant;
        this.anneeScolaire = anneeScolaire;
        this.niveau = niveau;
        this.statut = statut;
    }

    public DomainEtudiant getEtudiant() { return etudiant; }
    public void setEtudiant(DomainEtudiant etudiant) { this.etudiant = etudiant; }

    public DomainAnneeScolaire getAnneeScolaire() { return anneeScolaire; }
    public void setAnneeScolaire(DomainAnneeScolaire anneeScolaire) { this.anneeScolaire = anneeScolaire; }

    public DomainNiveau getNiveau() { return niveau; }
    public void setNiveau(DomainNiveau niveau) { this.niveau = niveau; }

    public Integer getStatut() { return statut; }
    public void setStatut(Integer statut) { this.statut = statut; }
}
