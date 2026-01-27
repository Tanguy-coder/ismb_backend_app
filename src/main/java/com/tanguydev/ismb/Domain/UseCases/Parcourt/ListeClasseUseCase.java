package com.tanguydev.ismb.Domain.UseCases.Parcourt;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Ports.ParcourtServiceInterface;

import java.util.List;

public class ListeClasseUseCase implements ListeClasseUseCaseInterface {
    private final ParcourtServiceInterface parcourtService;

    public ListeClasseUseCase(ParcourtServiceInterface parcourtService) {
        this.parcourtService = parcourtService;
    }

    @Override
    public List<DomainEtudiant> execute( Long filiereId, Long anneeScolaireId) {
        return this.parcourtService.listeClasse( filiereId, anneeScolaireId);
    }
}
