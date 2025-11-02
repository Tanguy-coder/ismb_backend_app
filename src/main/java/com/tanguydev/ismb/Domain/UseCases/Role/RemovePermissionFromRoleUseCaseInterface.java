package com.tanguydev.ismb.Domain.UseCases.Role;

import com.tanguydev.ismb.Domain.Entity.DomainRole;

import java.util.Optional;

public interface RemovePermissionFromRoleUseCaseInterface {
    Optional<DomainRole> execute(Long roleId, Long permissionId);
}
