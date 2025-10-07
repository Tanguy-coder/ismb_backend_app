package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;

public class UpdateAnneeUseCase implements UpdateAnneeUseCaseInterface{
    private final AnneeScolaireServiceInterface service;

    public UpdateAnneeUseCase(AnneeScolaireServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainAnneeScolaire execute(Long id, DomainAnneeScolaire anneeScolaire) {
        return this.service.update(id,anneeScolaire);
    }
}
