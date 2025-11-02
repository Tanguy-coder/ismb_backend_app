package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FiliereResponse {
    private Long id;
    private String libelle;
    private Niveau niveau;
    private String description;
}
