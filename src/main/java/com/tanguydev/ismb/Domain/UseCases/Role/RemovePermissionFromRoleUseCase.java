package com.tanguydev.ismb.Domain.UseCases.Role;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Ports.RoleServiceInterface;

import java.util.Optional;

public class RemovePermissionFromRoleUseCase implements RemovePermissionFromRoleUseCaseInterface {

    private final RoleServiceInterface roleService;

    public RemovePermissionFromRoleUseCase(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }

    @Override
    public Optional<DomainRole> execute(Long roleId, Long permissionId) {
        return roleService.removePermissionFromRole(roleId, permissionId);
    }
}
