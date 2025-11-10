package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

import java.util.Set;

public class CreateMatiereUseCase implements CreateMatiereUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public CreateMatiereUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public DomainMatiere execute(DomainMatiere domainMatiere, Set<Long> niveauIds) {
        return matiereService.save(domainMatiere, niveauIds);
    }
}
