package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;

public class DeletePermissionUseCase implements DeletePermissionUseCaseInterface {

    private final PermissionServiceInterface permissionService;

    public DeletePermissionUseCase(PermissionServiceInterface permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public void execute(Long id) {
        permissionService.deletePermission(id);
    }
}
