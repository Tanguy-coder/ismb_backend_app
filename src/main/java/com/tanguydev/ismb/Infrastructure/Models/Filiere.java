package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "filieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Filiere extends  AbstractModel{

    @Column(length = 100, nullable = false)
    private String libelle; // MIR1, etc.

    @ManyToOne
    @JoinColumn(name = "niveau_id", nullable = false)
    private Niveau niveau;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "filiere")
    private Set<Ue> ues;

    @OneToMany(mappedBy = "filiere")
    private Set<ParcourtEtudiant> parcours;
}
