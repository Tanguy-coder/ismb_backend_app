package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;

public class UpdateFiliereUseCase implements UpdateFiliereUseCaseInterface{
    private final FiliereServiceInterface service;

    public UpdateFiliereUseCase(FiliereServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainFiliere execute(Long id, DomainFiliere filiere) {
        return this.service.update(id,filiere);
    }
}
