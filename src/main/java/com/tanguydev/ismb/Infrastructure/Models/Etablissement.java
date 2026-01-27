package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "etablissements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etablissement extends AbstractModel{
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String contact;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private String numero;
    @Column(nullable = true)
    private String devise;
    @Column(nullable = true)
    private String ministere;
    @Column(nullable = false)
    private String logo;
    @Column(nullable = true)
    private String image;

}
