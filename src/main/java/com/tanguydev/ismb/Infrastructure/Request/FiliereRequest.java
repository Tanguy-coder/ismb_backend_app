package com.tanguydev.ismb.Infrastructure.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereRequest {
    private String libelle;
    private Long niveauId;
    private String description;
}
