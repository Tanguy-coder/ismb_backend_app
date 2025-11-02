package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Gateway.PermissionRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.RoleRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.RoleServiceInterface;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService implements RoleServiceInterface {

    private final RoleRepositoryInterface roleRepository;
    private final PermissionRepositoryInterface permissionRepository;

    public RoleService(RoleRepositoryInterface roleRepository, PermissionRepositoryInterface permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<DomainRole> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<DomainRole> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<DomainRole> addPermissionToRole(Long roleId, Long permissionId) {
        return roleRepository.findById(roleId).flatMap(role ->
                permissionRepository.findById(permissionId).map(permission -> {
                    Set<DomainPermission> permissions = new HashSet<>(role.getPermissions());
                    permissions.add(permission);
                    DomainRole updatedRole = new DomainRole(role.getName(), permissions);
                    updatedRole.setId(role.getId());
                    return roleRepository.save(updatedRole);
                })
        );
    }

    @Override
    public Optional<DomainRole> removePermissionFromRole(Long roleId, Long permissionId) {
        return roleRepository.findById(roleId).flatMap(role ->
                permissionRepository.findById(permissionId).map(permission -> {
                    Set<DomainPermission> permissions = new HashSet<>(role.getPermissions());
                    permissions.remove(permission);
                    DomainRole updatedRole = new DomainRole(role.getName(), permissions);
                    updatedRole.setId(role.getId());
                    return roleRepository.save(updatedRole);
                })
        );
    }
}
