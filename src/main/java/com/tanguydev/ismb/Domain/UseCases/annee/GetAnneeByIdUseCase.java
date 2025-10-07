package com.tanguydev.ismb.Domain.UseCases.annee;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;

public class GetAnneeByIdUseCase implements GetAnneeByIdUseCaseInterface{
    private final AnneeScolaireServiceInterface service;

    public GetAnneeByIdUseCase(AnneeScolaireServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainAnneeScolaire execute(Long id) {
        return this.service.getById(id);
    }
}
