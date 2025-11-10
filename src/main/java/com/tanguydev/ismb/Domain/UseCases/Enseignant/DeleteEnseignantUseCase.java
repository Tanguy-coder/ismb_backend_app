package com.tanguydev.ismb.Domain.UseCases.Enseignant;

import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;

public class DeleteEnseignantUseCase {
    private final EnseignantServiceInterface enseignantService;

    public DeleteEnseignantUseCase(EnseignantServiceInterface enseignantService) {
        this.enseignantService = enseignantService;
    }

    public void execute(Long id) {
        enseignantService.delete(id);
    }
}
