package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final UserRepositoryJpaInterface repository;
    private final UserMapper mapper;
    private final RoleJpaRepository roleJpaRepository;

    public UserRepository(UserRepositoryJpaInterface repository, UserMapper mapper, RoleJpaRepository roleJpaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.roleJpaRepository = roleJpaRepository;
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
        
        // Vérifier si le username existe déjà
        if (repository.findByUsername(jpaUser.getUsername()).isPresent()) {
            throw new DuplicateResourceException("User", "username", jpaUser.getUsername());
        }
        
        // Vérifier si l'email existe déjà
        if (repository.findByUsernameOrEmail("", jpaUser.getEmail()).isPresent()) {
            throw new DuplicateResourceException("User", "email", jpaUser.getEmail());
        }
        
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
         User existingUser = repository.findById(id).orElseThrow(()->new RuntimeException("User Not Found"));
         
         // Vérifier si le nouveau username existe déjà (sur un autre utilisateur)
         if (user.getUsername() != null && !user.getUsername().equals(existingUser.getUsername())) {
             if (repository.findByUsername(user.getUsername()).isPresent()) {
                 throw new DuplicateResourceException("User", "username", user.getUsername());
             }
             existingUser.setUsername(user.getUsername());
         }
         
         // Vérifier si le nouvel email existe déjà (sur un autre utilisateur)
         if (user.getEmail() != null && !user.getEmail().equals(existingUser.getEmail())) {
             if (repository.findByUsernameOrEmail("", user.getEmail()).isPresent()) {
                 throw new DuplicateResourceException("User", "email", user.getEmail());
             }
             existingUser.setEmail(user.getEmail());
         }
         
         existingUser.setNom(user.getNom());
         existingUser.setPrenom(user.getPrenom());
         existingUser.setContact(user.getContact());
         
         // Ne mettre à jour le mot de passe que s'il est fourni et non vide
         if (user.getPassword() != null && !user.getPassword().isEmpty()) {
         existingUser.setPassword(user.getPassword());
         }
         
         // Charger les rôles existants depuis la base de données pour éviter l'erreur TransientObjectException
         Set<Role> roles = new HashSet<>();
         if (user.getRoles() != null) {
             for (var domainRole : user.getRoles()) {
                 ERole eRole = domainRole.getName();
                 roleJpaRepository.findByName(eRole)
                     .ifPresent(roles::add);
             }
         }
         existingUser.setRoles(roles);

        return mapper.toDomain(repository.save(existingUser));

    }

    @Override
    public List<DomainUser> getAll() {
        return this.repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
