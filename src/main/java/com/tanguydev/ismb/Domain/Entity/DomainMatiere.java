package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainMatiere extends AbstractEntity{
    private String libelle;
    private String sigle;
    private String type;
    private Set<DomainNiveau> niveaux;
}
