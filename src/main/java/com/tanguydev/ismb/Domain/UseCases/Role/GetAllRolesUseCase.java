package com.tanguydev.ismb.Domain.UseCases.Role;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Ports.RoleServiceInterface;

import java.util.List;

public class GetAllRolesUseCase implements GetAllRolesUseCaseInterface {

    private final RoleServiceInterface roleService;

    public GetAllRolesUseCase(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }

    @Override
    public List<DomainRole> execute() {
        return roleService.getAllRoles();
    }
}
