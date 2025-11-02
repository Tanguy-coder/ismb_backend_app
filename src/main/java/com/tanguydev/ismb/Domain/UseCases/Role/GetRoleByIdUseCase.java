package com.tanguydev.ismb.Domain.UseCases.Role;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Ports.RoleServiceInterface;

import java.util.Optional;

public class GetRoleByIdUseCase implements GetRoleByIdUseCaseInterface {

    private final RoleServiceInterface roleService;

    public GetRoleByIdUseCase(RoleServiceInterface roleService) {
        this.roleService = roleService;
    }

    @Override
    public Optional<DomainRole> execute(Long id) {
        return roleService.getRoleById(id);
    }
}
