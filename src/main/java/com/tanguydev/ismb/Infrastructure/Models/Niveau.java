package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "niveaus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Niveau extends AbstractModel{
    @Column(length = 100, nullable = false)
    private String libelle; // BTS, Licence, Certificat

    @OneToMany(mappedBy = "niveau")
    private Set<Filiere> filieres;

    @OneToMany(mappedBy = "niveau")
    private Set<Etudiant> etudiants;

    @OneToMany(mappedBy = "niveau")
    private Set<Ue> ues;

    @OneToMany(mappedBy = "niveau")
    private Set<ParcourtEtudiant> parcours;
}
