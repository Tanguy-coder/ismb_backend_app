package com.tanguydev.ismb.Domain.UseCases.Ue;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;

public class UpdateUeUseCase {
    private final UeServiceInterface ueService;

    public UpdateUeUseCase(UeServiceInterface ueService) {
        this.ueService = ueService;
    }

    public DomainUe execute(Long id, DomainUe domainUe, Long matiereId, Long enseignantId, Long anneeScolaireId, Long filiereId) {
        return ueService.update(id, domainUe, matiereId, enseignantId, anneeScolaireId, filiereId);
    }
}
