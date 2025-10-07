package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereResponse {
    private Long id;
    private String libelle;
    private Long niveauId;
    private String description;
}
