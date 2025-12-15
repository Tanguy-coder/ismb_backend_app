package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

@Data
public class NoteRequest {
    private AnneeScolaireIdRequest anneeScolaire;
    private EtudiantRequest etudiant;
    private FiliereIdRequest filiere;
    private UeRequest ue;
    private Float cc;
    private Float tp;
    private Float examen;
    private Float moyenne;
    private String session;
    private Integer periode;
    private String mention;
}
