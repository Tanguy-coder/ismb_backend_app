package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;

import java.util.Optional;

public class UpdatePermissionUseCase implements UpdatePermissionUseCaseInterface {

    private final PermissionServiceInterface permissionService;

    public UpdatePermissionUseCase(PermissionServiceInterface permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public Optional<DomainPermission> execute(Long id, DomainPermission permission) {
        return permissionService.updatePermission(id, permission);
    }
}
