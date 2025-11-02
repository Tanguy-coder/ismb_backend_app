package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;

public class DeleteMatiereUseCase implements DeleteMatiereUseCaseInterface {
    private final MatiereServiceInterface matiereService;

    public DeleteMatiereUseCase(MatiereServiceInterface matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public void execute(Long id) {
        matiereService.delete(id);
    }
}
