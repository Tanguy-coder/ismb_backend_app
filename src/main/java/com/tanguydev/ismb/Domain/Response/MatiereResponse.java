package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereResponse {
    private long id;
    private String libelle;
    private String sigle;
    private String type;
    private Set<NiveauResponse> niveaux;
}
