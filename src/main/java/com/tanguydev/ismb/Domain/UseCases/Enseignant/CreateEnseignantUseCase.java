package com.tanguydev.ismb.Domain.UseCases.Enseignant;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;
import org.springframework.web.multipart.MultipartFile;

public class CreateEnseignantUseCase {
    private final EnseignantServiceInterface enseignantService;

    public CreateEnseignantUseCase(EnseignantServiceInterface enseignantService) {
        this.enseignantService = enseignantService;
    }

    public DomainEnseignant execute(DomainEnseignant domainEnseignant, MultipartFile photoFile) {
        return enseignantService.save(domainEnseignant, photoFile);
    }
}
