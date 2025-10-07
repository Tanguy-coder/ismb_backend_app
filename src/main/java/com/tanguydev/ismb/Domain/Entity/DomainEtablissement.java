package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainEtablissement extends AbstractEntity{
    private String nom;
    private String contact;
    private String email;
    private String numero;
    private String logo;
    private String image;
}
