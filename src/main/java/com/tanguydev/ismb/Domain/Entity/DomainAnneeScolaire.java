package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainAnneeScolaire extends AbstractEntity {
    private String code;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Boolean isActive;
}
