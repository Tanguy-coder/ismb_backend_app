package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainRole;

import java.util.List;
import java.util.Optional;

public interface RoleRepositoryInterface {
    List<DomainRole> findAll();
    Optional<DomainRole> findById(Long id);
    DomainRole save(DomainRole domainRole);
    Optional<DomainRole> findByName(String name);
}
