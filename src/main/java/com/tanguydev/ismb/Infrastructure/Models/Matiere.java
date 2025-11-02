package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "niveau_id")
    private Niveau niveau;
}