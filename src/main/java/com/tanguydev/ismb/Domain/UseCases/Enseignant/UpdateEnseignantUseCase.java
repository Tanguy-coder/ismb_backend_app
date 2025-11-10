package com.tanguydev.ismb.Domain.UseCases.Enseignant;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;
import org.springframework.web.multipart.MultipartFile;

public class UpdateEnseignantUseCase {
    private final EnseignantServiceInterface enseignantService;

    public UpdateEnseignantUseCase(EnseignantServiceInterface enseignantService) {
        this.enseignantService = enseignantService;
    }

    public DomainEnseignant execute(Long id, DomainEnseignant domainEnseignant, MultipartFile photoFile) {
        return enseignantService.update(id, domainEnseignant, photoFile);
    }
}
