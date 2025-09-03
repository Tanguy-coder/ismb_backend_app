package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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
    private Date date_debut;
    @Column(nullable = false)
    private Date date_fin;
    private Boolean is_active;

}
