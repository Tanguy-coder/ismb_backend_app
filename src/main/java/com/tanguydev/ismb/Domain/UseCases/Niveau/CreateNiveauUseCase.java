package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;

public class CreateNiveauUseCase implements CreateNiveauUseCaseInterface{
   private final NiveauServiceInterface service;

    public CreateNiveauUseCase(NiveauServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainNiveau execute(DomainNiveau niveau) {
        return this.service.save(niveau);
    }
}
