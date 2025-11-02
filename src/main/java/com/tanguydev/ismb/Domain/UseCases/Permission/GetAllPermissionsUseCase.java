package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;

import java.util.List;

public class GetAllPermissionsUseCase implements GetAllPermissionsUseCaseInterface {

    private final PermissionServiceInterface permissionService;

    public GetAllPermissionsUseCase(PermissionServiceInterface permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public List<DomainPermission> execute() {
        return permissionService.getAllPermissions();
    }
}
