package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "etudiants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends AbstractModel{
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // lien avec table users

    @Column(nullable = false, length = 1)
    private String sexe; // M/F

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(length = 20)
    private String telephone;

    @Column(length = 50)
    private String nationalite;

    @Column(length = 255)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "niveau_id", nullable = false)
    private Niveau niveau;

    @OneToMany(mappedBy = "etudiant")
    private Set<Note> notes;

    @OneToMany(mappedBy = "etudiant")
    private Set<ParcourtEtudiant> parcours;

    @Lob
    private String attentes;
}
