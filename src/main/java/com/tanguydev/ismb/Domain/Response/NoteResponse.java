package com.tanguydev.ismb.Domain.Response;

import lombok.Data;

@Data
public class NoteResponse {
    private Long id;
    private EtudiantResponse etudiant;
    private UeResponse ue;
    private FiliereResponse filiere;
    private Float cc;
    private Float tp;
    private Float examen;
    private Float moyenne;
    private String session;
    private String mention;
    private AnneeScolaireResponse anneeScolaire;
}
