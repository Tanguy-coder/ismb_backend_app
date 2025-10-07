package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import org.springframework.web.multipart.MultipartFile;

public class UpdateEtudiantUseCase implements UpdateEtudiantUseCaseInterface {
    private final EtudiantServiceInterface service;

    public UpdateEtudiantUseCase(EtudiantServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainEtudiant execute(Long id, DomainEtudiant domainEtudiant, MultipartFile photoFile) {
        return this.service.update(id, domainEtudiant, photoFile);
    }
}
