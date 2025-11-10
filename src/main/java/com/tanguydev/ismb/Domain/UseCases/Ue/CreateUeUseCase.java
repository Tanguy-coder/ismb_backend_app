package com.tanguydev.ismb.Domain.UseCases.Ue;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;

public class CreateUeUseCase {
    private final UeServiceInterface ueService;

    public CreateUeUseCase(UeServiceInterface ueService) {
        this.ueService = ueService;
    }

    public DomainUe execute(DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId) {
        return ueService.save(domainUe, matiereId, enseignantId, anneeScolaireId, filiereId);
    }
}
