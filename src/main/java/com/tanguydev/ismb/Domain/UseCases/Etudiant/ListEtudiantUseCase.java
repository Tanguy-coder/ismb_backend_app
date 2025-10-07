package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;

import java.util.List;

public class ListEtudiantUseCase implements ListEtudiantUseCaseInterface {
    private final EtudiantServiceInterface service;

    public ListEtudiantUseCase(EtudiantServiceInterface service) {
        this.service = service;
    }

    @Override
    public List<DomainEtudiant> execute() {
        return this.service.getAll();
    }
}
