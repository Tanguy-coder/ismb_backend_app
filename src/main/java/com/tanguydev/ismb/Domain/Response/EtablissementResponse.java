package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementResponse {
    private Long id;
    private String nom;
    private String contact;
    private String email;
    private String numero;
    private String logo;
    private String image;
}
