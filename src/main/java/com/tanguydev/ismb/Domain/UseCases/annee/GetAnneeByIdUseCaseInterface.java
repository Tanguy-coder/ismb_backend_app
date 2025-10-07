package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

public interface GetAnneeByIdUseCaseInterface {
    DomainAnneeScolaire execute(Long id);
}
