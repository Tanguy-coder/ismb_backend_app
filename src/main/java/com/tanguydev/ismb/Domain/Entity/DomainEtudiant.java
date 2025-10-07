package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEtudiant extends AbstractEntity {
    private DomainUser user;
    private String sexe;
    private LocalDate dateNaissance;
    private String telephone;
    private String nationalite;
    private String photo;
    private DomainNiveau niveau;
    private Set<DomainNote> notes;
    private Set<DomainParcourtEtudiant> parcours;
    private String attentes;
}
