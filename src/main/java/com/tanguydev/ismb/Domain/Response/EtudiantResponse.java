package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantResponse {
    private Long id;
    private Long userId;
    private String sexe;
    private LocalDate dateNaissance;
    private String telephone;
    private String nationalite;
    private String photo;
    private Long niveauId;
    private String attentes;
}
