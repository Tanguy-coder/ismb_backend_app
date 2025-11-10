package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

import java.util.Set;

@Data
public class MatiereRequest {
    private String libelle;
    private String sigle;
    private String type;
    private Set<NiveauRequest> niveauRequests;
}
