package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;

import java.util.List;

public class ListFiliereUseCase implements ListFiliereUseCaseInterface{
    private final FiliereServiceInterface service;

    public ListFiliereUseCase(FiliereServiceInterface service) {
        this.service = service;
    }

    @Override
    public List<DomainFiliere> execute() {
        return this.service.getAll();
    }
}
