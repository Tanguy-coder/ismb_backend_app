package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

import java.util.List;
import java.util.Optional;

public interface PermissionRepositoryInterface {
    List<DomainPermission> findAll();
    Optional<DomainPermission> findById(Long id);
    DomainPermission save(DomainPermission domainPermission);
    void deleteById(Long id);
    Optional<DomainPermission> findByName(String name);
}
