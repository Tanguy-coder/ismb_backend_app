package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;

public class CreatePermissionUseCase implements CreatePermissionUseCaseInterface {

    private final PermissionServiceInterface permissionService;

    public CreatePermissionUseCase(PermissionServiceInterface permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public DomainPermission execute(DomainPermission permission) {
        return permissionService.createPermission(permission);
    }
}
