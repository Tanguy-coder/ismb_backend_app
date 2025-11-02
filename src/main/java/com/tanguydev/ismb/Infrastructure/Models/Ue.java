package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ue extends AbstractModel{
    @Column(length = 100, nullable = false)
    private String libelle;

    @Column(length = 20, nullable = false)
    private String semestre;

    @ManyToOne
    @JoinColumn(name = "filiere_id", nullable = false)
    private Filiere filiere;

    @Column(name = "volume_horaire", nullable = false)
    private Integer volumeHoraire;

    @OneToMany(mappedBy = "ue")
    private Set<Note> notes;
}
