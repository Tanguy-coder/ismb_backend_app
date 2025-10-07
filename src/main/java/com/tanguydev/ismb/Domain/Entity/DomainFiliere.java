package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainFiliere extends AbstractEntity {
    private String libelle;
    private DomainNiveau niveau;
    private String description;
}
