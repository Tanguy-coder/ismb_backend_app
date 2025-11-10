package com.tanguydev.ismb.Domain.UseCases.Ue;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;

public class GetUeByIdUseCase {
    private final UeServiceInterface ueService;

    public GetUeByIdUseCase(UeServiceInterface ueService) {
        this.ueService = ueService;
    }

    public DomainUe execute(Long id) {
        return ueService.findById(id);
    }
}
