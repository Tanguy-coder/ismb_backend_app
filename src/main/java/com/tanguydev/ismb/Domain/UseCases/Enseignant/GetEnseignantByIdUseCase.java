package com.tanguydev.ismb.Domain.UseCases.Enseignant;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;

public class GetEnseignantByIdUseCase {
    private final EnseignantServiceInterface enseignantService;

    public GetEnseignantByIdUseCase(EnseignantServiceInterface enseignantService) {
        this.enseignantService = enseignantService;
    }

    public DomainEnseignant execute(Long id) {
        return enseignantService.findById(id);
    }
}
