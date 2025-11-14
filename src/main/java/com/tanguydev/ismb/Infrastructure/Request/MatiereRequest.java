package com.tanguydev.ismb.Infrastructure.Request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.Set;

@Data
public class MatiereRequest {
    private String libelle;
    private String sigle;
    private String type;

    @JsonAlias({"niveaux"})
    private Set<NiveauRequest> niveauRequests;

    private Set<Long> niveauIds;
}
