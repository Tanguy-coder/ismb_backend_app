package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

import java.util.List;

public interface AnneeScolaireServiceInterface {
    DomainAnneeScolaire save(DomainAnneeScolaire anneeScolaire);
    DomainAnneeScolaire getById(Long id);
    List<DomainAnneeScolaire>getAll();
    DomainAnneeScolaire update(Long id, DomainAnneeScolaire anneeScolaire);

}
