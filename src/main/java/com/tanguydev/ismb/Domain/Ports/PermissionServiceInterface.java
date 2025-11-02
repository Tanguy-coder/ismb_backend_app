package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

import java.util.List;
import java.util.Optional;

public interface PermissionServiceInterface {
    List<DomainPermission> getAllPermissions();
    Optional<DomainPermission> getPermissionById(Long id);
    DomainPermission createPermission(DomainPermission domainPermission);
    Optional<DomainPermission> updatePermission(Long id, DomainPermission domainPermission);
    void deletePermission(Long id);
}
