package com.tanguydev.ismb.Domain.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnneeScolaireResponse {
    private Long id;
    private String code;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Boolean isActive;
}