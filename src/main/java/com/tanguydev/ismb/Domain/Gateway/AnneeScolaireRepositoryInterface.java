package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

import java.util.List;
import java.util.Optional;

public interface AnneeScolaireRepositoryInterface {
    DomainAnneeScolaire save(DomainAnneeScolaire anneeScolaire);
    DomainAnneeScolaire getById(Long id);
    List<DomainAnneeScolaire> getAll();
    DomainAnneeScolaire update(Long id, DomainAnneeScolaire anneeScolaire);
    Optional<DomainAnneeScolaire> findByAnnee(String annee);
    Optional<DomainAnneeScolaire> findLastRegisteredAnneeScolaire();
}
