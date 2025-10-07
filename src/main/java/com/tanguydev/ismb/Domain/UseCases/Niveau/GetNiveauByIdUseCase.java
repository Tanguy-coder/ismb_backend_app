package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;

public class GetNiveauByIdUseCase implements GetNiveauByIdUseCaseInterface{
    private final NiveauServiceInterface service;

    public GetNiveauByIdUseCase(NiveauServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainNiveau execute(Long id) {
        return this.service.findById(id);
    }
}
