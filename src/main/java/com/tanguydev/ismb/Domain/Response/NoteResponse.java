package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.*;

public class NoteResponse {
    private DomainEtudiant etudiant;
    private DomainUe ue;
    private Float cc;
    private Float tp;
    private Float examen;
    private Float moyenne;
    private String session;
    private DomainAnneeScolaire anneeScolaire;

    public DomainEtudiant getEtudiant() { return etudiant; }
    public DomainUe getUe() { return ue; }
    public Float getCc() { return cc; }
    public Float getTp() { return tp; }
    public Float getExamen() { return examen; }
    public Float getMoyenne() { return moyenne; }
    public String getSession() { return session; }
    public DomainAnneeScolaire getAnneeScolaire() { return anneeScolaire; }
}