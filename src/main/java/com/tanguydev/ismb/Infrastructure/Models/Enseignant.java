package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "enseignants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Enseignant extends AbstractModel {
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

    @Column(length = 255, nullable = true)
    private String photo;

    @Column(nullable = true)
    private String matiere;

    @Column(nullable = false, length = 1)
    private boolean etat = true;
}