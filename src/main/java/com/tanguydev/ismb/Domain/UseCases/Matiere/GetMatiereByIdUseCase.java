package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

public class GetMatiereByIdUseCase implements GetMatiereByIdUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public GetMatiereByIdUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public DomainMatiere execute(Long id) {
        return matiereService.findById(id);
    }
}
