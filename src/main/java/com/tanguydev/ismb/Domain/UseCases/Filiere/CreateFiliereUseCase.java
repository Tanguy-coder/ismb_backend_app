package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;

public class CreateFiliereUseCase implements CreateFiliereUseCaseInterface{
    private final FiliereServiceInterface service;

    public CreateFiliereUseCase(FiliereServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainFiliere execute(DomainFiliere filiere) {
        return this.service.save(filiere);
    }
}
