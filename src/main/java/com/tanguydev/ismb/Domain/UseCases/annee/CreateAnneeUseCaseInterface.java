package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

public interface CreateAnneeUseCaseInterface {
    DomainAnneeScolaire execute(DomainAnneeScolaire anneeScolaire);
}
