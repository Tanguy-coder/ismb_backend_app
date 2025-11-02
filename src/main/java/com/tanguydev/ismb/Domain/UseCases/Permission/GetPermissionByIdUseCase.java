package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;

import java.util.Optional;

public class GetPermissionByIdUseCase implements GetPermissionByIdUseCaseInterface {

    private final PermissionServiceInterface permissionService;

    public GetPermissionByIdUseCase(PermissionServiceInterface permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public Optional<DomainPermission> execute(Long id) {
        return permissionService.getPermissionById(id);
    }
}
