package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

@Data
public class UeRequest {
    private String libelle;
    private Integer credits;
    private FiliereIdRequest filiere;
    private Integer volumeHoraire;
    private MatiereIdRequest matiere;
    private EnseignantIdRequest enseignant;
    private AnneeScolaireIdRequest anneeScolaire;
}
