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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 1)
    private String sexe;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Column(name = "lieu_de_naissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "telephone", length = 20)
    private String telephone;

    @Column(length = 50)
    private String nationalite;

    @Column(name = "filiere_integration", nullable = false)
    private Filiere filiere;

    @Column(length = 255, nullable = true)
    private String photo;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Note> notes;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ParcourtEtudiant> parcours;

    @Lob
    private String attentes;
}
