package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;

import java.util.List;

public class ListEtablissementUseCase implements ListEtablissementUseCaseInterface {

    private final EtablissementServiceInterface service;

    public ListEtablissementUseCase(EtablissementServiceInterface service) {
        this.service = service;
    }

    @Override
    public List<DomainEtablissement> execute() {
        return service.getAll();
    }
}
