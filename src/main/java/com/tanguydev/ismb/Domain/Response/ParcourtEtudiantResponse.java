package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.*;

public class ParcourtEtudiantResponse {
    private DomainEtudiant etudiant;
    private DomainAnneeScolaire anneeScolaire;
    private DomainNiveau niveau;
    private Integer statut;

    public DomainEtudiant getEtudiant() { return etudiant; }
    public DomainAnneeScolaire getAnneeScolaire() { return anneeScolaire; }
    public DomainNiveau getNiveau() { return niveau; }
    public Integer getStatut() { return statut; }
}