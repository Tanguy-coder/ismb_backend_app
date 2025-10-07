package com.tanguydev.ismb.Domain.Entity;

public class DomainNote extends AbstractEntity {
    private DomainEtudiant etudiant;
    private DomainUe ue;
    private Float cc;
    private Float tp;
    private Float examen;
    private Float moyenne;
    private String session;
    private DomainAnneeScolaire anneeScolaire;

    public DomainNote() {}

    public DomainNote(DomainEtudiant etudiant, DomainUe ue) {
        this.etudiant = etudiant;
        this.ue = ue;
    }

    public DomainEtudiant getEtudiant() { return etudiant; }
    public void setEtudiant(DomainEtudiant etudiant) { this.etudiant = etudiant; }

    public DomainUe getUe() { return ue; }
    public void setUe(DomainUe ue) { this.ue = ue; }

    public Float getCc() { return cc; }
    public void setCc(Float cc) { this.cc = cc; }

    public Float getTp() { return tp; }
    public void setTp(Float tp) { this.tp = tp; }

    public Float getExamen() { return examen; }
    public void setExamen(Float examen) { this.examen = examen; }

    public Float getMoyenne() { return moyenne; }
    public void setMoyenne(Float moyenne) { this.moyenne = moyenne; }

    public String getSession() { return session; }
    public void setSession(String session) { this.session = session; }

    public DomainAnneeScolaire getAnneeScolaire() { return anneeScolaire; }
    public void setAnneeScolaire(DomainAnneeScolaire anneeScolaire) { this.anneeScolaire = anneeScolaire; }
}
