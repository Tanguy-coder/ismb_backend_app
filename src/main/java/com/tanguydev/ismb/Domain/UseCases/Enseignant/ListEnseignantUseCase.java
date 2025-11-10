package com.tanguydev.ismb.Domain.UseCases.Enseignant;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;

import java.util.List;

public class ListEnseignantUseCase {
    private final EnseignantServiceInterface enseignantService;

    public ListEnseignantUseCase(EnseignantServiceInterface enseignantService) {
        this.enseignantService = enseignantService;
    }

    public List<DomainEnseignant> execute() {
        return enseignantService.getAll();
    }
}
