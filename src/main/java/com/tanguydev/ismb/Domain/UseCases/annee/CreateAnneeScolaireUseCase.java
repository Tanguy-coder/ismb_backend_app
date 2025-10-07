package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;

public class CreateAnneeScolaireUseCase implements CreateAnneeUseCaseInterface{
    private final AnneeScolaireServiceInterface service;

    public CreateAnneeScolaireUseCase(AnneeScolaireServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainAnneeScolaire execute(DomainAnneeScolaire anneeScolaire) {
        return this.service.save(anneeScolaire);
    }
}
