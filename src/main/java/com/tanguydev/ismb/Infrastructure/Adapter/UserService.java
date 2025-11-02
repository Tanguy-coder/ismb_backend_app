package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.RoleRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepositoryInterface repository;
    private final PasswordEncoder passwordEncoder;

    private final RoleRepositoryInterface roleRepository;

    public UserService(UserRepositoryInterface repository, PasswordEncoder passwordEncoder, RoleRepositoryInterface roleRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<DomainUser> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public DomainUser save(DomainUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<DomainRole> roles = user.getRoles().stream()
                .map(role -> roleRepository.findByName(role.getName().toString()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return this.repository.save(user);
    }

    @Override
    public DomainUser findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public DomainUser update(Long id, DomainUser user) {
        return this.repository.update(id, user);
    }

    @Override
    public List<DomainUser> getAll() {
        return this.repository.getAll();
    }
}