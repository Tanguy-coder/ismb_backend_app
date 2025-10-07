package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;

public class GetFiliereByIdUseCase implements GetFiliereByIdUseCaseInterface{
    private final FiliereServiceInterface service;

    public GetFiliereByIdUseCase(FiliereServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainFiliere execute(Long id) {
        return this.service.findById(id);
    }
}
