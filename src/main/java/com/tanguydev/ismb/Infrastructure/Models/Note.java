package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note extends AbstractModel{
    @ManyToOne
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "ue_id", nullable = false)
    private Ue ue;
    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id", nullable = false)
    private AnneeScolaire anneeScolaire;
    @ManyToOne
    @JoinColumn(name = "filiere_id", nullable = false)
    private Filiere filiere;
    @Column(length = 20)
    private Float cc;
    @Column(length = 20)
    private Float tp;
    @Column(length = 20)
    private Float examen;
    @Column(length = 20)
    private Float moyenne;
    @Column(length = 255)
    private String session; //Normale ou rattrapage
    @Column(length = 11)
    private Integer periode; //harmattan ou mousson
    @Column(length = 255)
    private String mention;
    @Column(length = 11)
    private Integer moyCoeff;
}
