package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Ports.EtablissementServiceInterface;
import org.springframework.web.multipart.MultipartFile;

public class CreateEtablissementUseCase implements CreateEtablissementUseCaseInterface{
    private final EtablissementServiceInterface service;

    public CreateEtablissementUseCase(EtablissementServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtablissement execute(DomainEtablissement domainEtablissement, MultipartFile logoFile, MultipartFile imageFile) {
        return this.service.save(domainEtablissement, logoFile, imageFile);
    }
}
