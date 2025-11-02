package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainNiveau extends AbstractEntity {
    private String libelle;
    private Set<DomainFiliere> filieres;
    private Set<DomainUe> ues;
    private Set<DomainParcourtEtudiant> parcours;
}
