package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Entity.DomainRole;

import java.util.List;
import java.util.Optional;

public interface RoleServiceInterface {
    List<DomainRole> getAllRoles();
    Optional<DomainRole> getRoleById(Long id);
    Optional<DomainRole> addPermissionToRole(Long roleId, Long permissionId);
    Optional<DomainRole> removePermissionFromRole(Long roleId, Long permissionId);
}
