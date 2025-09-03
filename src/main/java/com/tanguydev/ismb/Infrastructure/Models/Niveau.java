package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "niveaus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Niveau extends AbstractModel{
    @Column(length = 100, nullable = false)
    private String libelle; // BTS, Licence, Certificat
    @OneToMany(mappedBy = "niveau")
    private Set<Filiere> filieres;
}
