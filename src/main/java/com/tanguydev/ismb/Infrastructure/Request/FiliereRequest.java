package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

@Data
public class FiliereRequest {
    private Long id;
    private String libelle;
    private String description;
    private NiveauRequest niveau;
}