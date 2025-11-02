package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Gateway.PermissionRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.PermissionServiceInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements PermissionServiceInterface {

    private final PermissionRepositoryInterface permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionRepositoryInterface permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Override
    public List<DomainPermission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<DomainPermission> getPermissionById(Long id) {
        return permissionRepository.findById(id);
    }

    @Override
    public DomainPermission createPermission(DomainPermission domainPermission) {
        return permissionRepository.save(domainPermission);
    }

    @Override
    public Optional<DomainPermission> updatePermission(Long id, DomainPermission domainPermission) {
        return permissionRepository.findById(id).map(existingPermission -> {
            existingPermission.setName(domainPermission.getName());
            return permissionRepository.save(existingPermission);
        });
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
