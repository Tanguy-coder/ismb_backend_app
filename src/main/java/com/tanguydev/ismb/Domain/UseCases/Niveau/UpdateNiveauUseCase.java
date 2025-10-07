package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;

public class UpdateNiveauUseCase implements UpdateNiuveauUseCaseInterface{
    private final NiveauServiceInterface service;

    public UpdateNiveauUseCase(NiveauServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainNiveau execute(Long id, DomainNiveau niveau) {
        return this.service.update(id, niveau);
    }
}
