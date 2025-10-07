package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "annee_scolaires")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
public class AnneeScolaire extends AbstractModel{
    @Column(unique = true,nullable = false)
    private String code;
    @Column(nullable = false)
    private LocalDate dateDebut;
    @Column(nullable = false)
    private LocalDate dateFin;
    private Boolean is_active;

    @OneToMany(mappedBy = "anneeScolaire")
    private Set<Note> notes;

    @OneToMany(mappedBy = "anneeScolaire")
    private Set<ParcourtEtudiant> parcours;
}
