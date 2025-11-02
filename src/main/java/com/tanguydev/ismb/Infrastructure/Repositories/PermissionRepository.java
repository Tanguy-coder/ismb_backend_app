package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Gateway.PermissionRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.PermissionMapper;
import com.tanguydev.ismb.Infrastructure.Models.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PermissionRepository implements PermissionRepositoryInterface {

    private final PermissionJpaRepository jpaRepository;
    private final PermissionMapper permissionMapper;

    public PermissionRepository(PermissionJpaRepository jpaRepository, PermissionMapper permissionMapper) {
        this.jpaRepository = jpaRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<DomainPermission> findAll() {
        return jpaRepository.findAll().stream()
                .map(permissionMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DomainPermission> findById(Long id) {
        return jpaRepository.findById(id).map(permissionMapper::toDomain);
    }

    @Override
    public DomainPermission save(DomainPermission domainPermission) {
        Permission permission = permissionMapper.toModel(domainPermission);
        return permissionMapper.toDomain(jpaRepository.save(permission));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<DomainPermission> findByName(String name) {
        return jpaRepository.findByName(name).map(permissionMapper::toDomain);
    }
}
