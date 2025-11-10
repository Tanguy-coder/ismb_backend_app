package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UeResponse {
    private Long id;
    private String libelle;
    private Integer credits;
    private FiliereResponse filiere;
    private Integer volumeHoraire;
    private Set<NoteResponse> notes;
    private MatiereResponse matiere;
    private EnseignantResponse enseignant;
    private AnneeScolaireResponse anneeScolaire;
}