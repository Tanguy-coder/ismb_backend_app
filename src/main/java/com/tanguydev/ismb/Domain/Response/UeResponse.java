package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.*;

import java.util.Set;

public class UeResponse {
    private String libelle;
    private String semestre;
    private DomainNiveau niveau;
    private Integer volumeHoraire;
    private Set<DomainNote> notes;

    public String getLibelle() { return libelle; }
    public String getSemestre() { return semestre; }
    public DomainNiveau getNiveau() { return niveau; }
    public Integer getVolumeHoraire() { return volumeHoraire; }
    public Set<DomainNote> getNotes() { return notes; }
}