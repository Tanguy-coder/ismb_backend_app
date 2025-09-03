package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "niveau_id", nullable = false)
    private Niveau niveau;

    @Column(name = "volume_horaire", nullable = false)
    private Integer volumeHoraire;
}
