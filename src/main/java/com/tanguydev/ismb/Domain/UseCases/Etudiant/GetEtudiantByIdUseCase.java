package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;

public class GetEtudiantByIdUseCase implements GetEtudiantByIdUseCaseInterface {
    private final EtudiantServiceInterface service;

    public GetEtudiantByIdUseCase(EtudiantServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtudiant execute(Long id) {
        return this.service.findById(id);
    }
}
