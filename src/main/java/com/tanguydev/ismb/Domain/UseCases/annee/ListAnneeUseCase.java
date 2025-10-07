package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;

import java.util.List;

public class ListAnneeUseCase implements ListAnneeUseCaseInterface{
    private final AnneeScolaireServiceInterface service;

    public ListAnneeUseCase(AnneeScolaireServiceInterface service) {
        this.service = service;
    }

    @Override
    public List<DomainAnneeScolaire> execute() {
        return this.service.getAll();
    }
}
