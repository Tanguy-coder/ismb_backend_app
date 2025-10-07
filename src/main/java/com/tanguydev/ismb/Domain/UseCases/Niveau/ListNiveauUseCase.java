package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;

import java.util.List;

public class ListNiveauUseCase implements ListNiveauUseCaseInterface{
    private final NiveauServiceInterface service;

    public ListNiveauUseCase(NiveauServiceInterface service) {
        this.service = service;
    }

    @Override
    public List<DomainNiveau> execute() {
        return this.service.getAll();
    }
}
