package com.tanguydev.ismb.Domain.UseCases.Ue;

import com.tanguydev.ismb.Domain.Ports.UeServiceInterface;

public class DeleteUeUseCase {
    private final UeServiceInterface ueService;

    public DeleteUeUseCase(UeServiceInterface ueService) {
        this.ueService = ueService;
    }

    public void execute(Long id) {
        ueService.delete(id);
    }
}
