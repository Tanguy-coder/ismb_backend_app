package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;

public class DeleteEtudiantUseCase implements DeleteEtudiantUseCaseInterface {

    private final EtudiantServiceInterface etudiantService;

    public DeleteEtudiantUseCase(EtudiantServiceInterface etudiantService) {
        this.etudiantService = etudiantService;
    }

    @Override
    public void execute(Long id) {
        etudiantService.delete(id);
    }
}
