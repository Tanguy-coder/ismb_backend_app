package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import org.springframework.web.multipart.MultipartFile;

public class CreateEtudiantUseCase implements CreateEtudiantUseCaseInterface {
    private final EtudiantServiceInterface service;

    public CreateEtudiantUseCase(EtudiantServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtudiant execute(DomainEtudiant domainEtudiant, MultipartFile photoFile, Long filiereId, String statut) {
        return this.service.save(domainEtudiant, photoFile, filiereId, statut);
    }
}
