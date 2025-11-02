package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

import java.util.List;

public class ListMatiereUseCase implements ListMatiereUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public ListMatiereUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public List<DomainMatiere> execute() {
        return matiereService.getAll();
    }
}
