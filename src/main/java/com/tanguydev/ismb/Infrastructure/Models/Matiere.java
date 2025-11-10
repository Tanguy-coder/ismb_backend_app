package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "matieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Matiere extends AbstractModel {
    private String libelle;
    private String sigle;
    private String type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "matiere_niveau",
            joinColumns = @JoinColumn(name = "matiere_id"),
            inverseJoinColumns = @JoinColumn(name = "niveau_id")
    )
    private Set<Niveau> niveaux;
}