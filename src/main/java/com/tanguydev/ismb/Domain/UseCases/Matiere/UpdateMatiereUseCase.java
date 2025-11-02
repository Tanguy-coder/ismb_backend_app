package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

public class UpdateMatiereUseCase implements UpdateMatiereUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public UpdateMatiereUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public DomainMatiere execute(Long id, DomainMatiere domainMatiere) {
        return matiereService.update(id, domainMatiere);
    }
}
