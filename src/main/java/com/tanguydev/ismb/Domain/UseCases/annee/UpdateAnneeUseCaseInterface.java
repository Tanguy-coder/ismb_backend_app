package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

public interface UpdateAnneeUseCaseInterface {
    DomainAnneeScolaire execute(Long id, DomainAnneeScolaire anneeScolaire);
}
