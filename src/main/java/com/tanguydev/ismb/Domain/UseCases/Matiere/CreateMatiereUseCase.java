package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

public class CreateMatiereUseCase implements CreateMatiereUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public CreateMatiereUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public DomainMatiere execute(DomainMatiere domainMatiere, Long niveauId) {
        return matiereService.save(domainMatiere, niveauId);
    }
}
