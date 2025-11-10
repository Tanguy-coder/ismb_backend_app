package com.tanguydev.ismb.Domain.UseCases.Ue;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;

import java.util.List;

public class ListUeUseCase {
    private final UeServiceInterface ueService;

    public ListUeUseCase(UeServiceInterface ueService) {
        this.ueService = ueService;
    }

    public List<DomainUe> execute() {
        return ueService.getAll();
    }
}
