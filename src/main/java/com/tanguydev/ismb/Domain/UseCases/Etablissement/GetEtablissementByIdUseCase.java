package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;

public class GetEtablissementByIdUseCase implements GetEtablissementByIdUseCaseInterface{
    private final EtablissementServiceInterface service;

    public GetEtablissementByIdUseCase(EtablissementServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtablissement execute(Long id) {
        return this.service.findById(id);
    }
}
