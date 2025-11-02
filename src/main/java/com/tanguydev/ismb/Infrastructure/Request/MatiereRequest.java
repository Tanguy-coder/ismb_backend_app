package com.tanguydev.ismb.Infrastructure.Request;

import lombok.Data;

@Data
public class MatiereRequest {
    private String libelle;
    private String sigle;
    private String type;
    private NiveauRequest niveau;
}
