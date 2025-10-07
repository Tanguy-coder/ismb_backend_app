package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;

public class UpdateEtablissementUseCase implements UpdateEtablissementUseCaseInterface{
    private final EtablissementServiceInterface service;

    public UpdateEtablissementUseCase(EtablissementServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtablissement execute(Long id, DomainEtablissement domainEtablissement) {
        return this.service.update(id, domainEtablissement);
    }
}
