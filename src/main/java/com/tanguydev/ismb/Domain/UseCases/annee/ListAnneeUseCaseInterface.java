package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;

import java.util.List;

public interface ListAnneeUseCaseInterface {
    List<DomainAnneeScolaire> execute();
}
