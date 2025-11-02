package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Gateway.RoleRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.RoleMapper;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoleRepository implements RoleRepositoryInterface {

    private final RoleJpaRepository jpaRepository;
    private final RoleMapper roleMapper;

    public RoleRepository(RoleJpaRepository jpaRepository, RoleMapper roleMapper) {
        this.jpaRepository = jpaRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<DomainRole> findAll() {
        return jpaRepository.findAll().stream()
                .map(roleMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DomainRole> findById(Long id) {
        return jpaRepository.findById(id).map(roleMapper::toDomain);
    }

    @Override
    public DomainRole save(DomainRole domainRole) {
        Role role = roleMapper.toModel(domainRole);
        return roleMapper.toDomain(jpaRepository.save(role));
    }

    @Override
    public Optional<DomainRole> findByName(String name) {
        // Convert String name to ERole for lookup
        try {
            ERole eRole = ERole.valueOf(name);
            return jpaRepository.findByName(eRole).map(roleMapper::toDomain);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
