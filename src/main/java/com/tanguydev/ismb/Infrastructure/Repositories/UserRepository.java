package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final UserRepositoryJpaInterface repository;
    private final UserMapper mapper;

    public UserRepository(UserRepositoryJpaInterface repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DomainUser> findByUsername(String username) {
        return this.repository.findByUsername(username).map(mapper::toDomain);
    }

    @Override
    public Optional<DomainUser> findByUsernameOrEmail(String username, String email) {
        return repository.findByUsernameOrEmail(username, email).map(mapper::toDomain);
    }

    @Override
    public DomainUser save(DomainUser user) {
        User jpaUser = mapper.toJpa(user);
        User savedUser = this.repository.save(jpaUser);
        return mapper.toDomain(savedUser);
    }

    @Override
    public DomainUser findById(Long id) {
        Optional<User> userOptional = this.repository.findById(id);
        return userOptional.map(mapper::toDomain).orElse(null); // Or throw an exception
    }

    @Override
    public DomainUser update(Long id, DomainUser user) {
         User jpaUser = repository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
         jpaUser.setNom(user.getNom());
         jpaUser.setPrenom(user.getPrenom());
         jpaUser.setContact(user.getContact());
         jpaUser.setEmail(user.getEmail());
         jpaUser.setPassword(user.getPassword());
         jpaUser.setRoles(mapper.toJpa(user.getRoles()));

        return mapper.toDomain(repository.save(jpaUser));

    }

    @Override
    public List<DomainUser> getAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
