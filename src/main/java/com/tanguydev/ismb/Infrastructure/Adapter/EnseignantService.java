package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.EnseignantRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.RoleRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.EnseignantServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FileStorageServiceInterface;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EnseignantService implements EnseignantServiceInterface {
    private final EnseignantRepositoryInterface repository;
    private final FileStorageServiceInterface fileStorageService;
    private final UserServiceInterface userService;
    private final RoleRepositoryInterface roleRepository;

    public EnseignantService(EnseignantRepositoryInterface repository, FileStorageServiceInterface fileStorageService, UserServiceInterface userService, RoleRepositoryInterface roleRepository) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public DomainEnseignant save(DomainEnseignant domainEnseignant, MultipartFile photoFile) {
        DomainUser userToCreate = domainEnseignant.getUser();

        if (userToCreate.getRoles() == null || userToCreate.getRoles().isEmpty()) {
            DomainRole userRole = roleRepository.findByName(ERole.User.name()).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            Set<DomainRole> roles = new HashSet<>();
            roles.add(userRole);
            userToCreate.setRoles(roles);
        }

        DomainUser createdUser = userService.save(userToCreate);
        domainEnseignant.setUser(createdUser);

        if (photoFile != null && !photoFile.isEmpty()) {
            String photoFileName = fileStorageService.save(photoFile);
            domainEnseignant.setPhoto(photoFileName);
        }

        return this.repository.save(domainEnseignant);
    }

    @Override
    public DomainEnseignant findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<DomainEnseignant> getAll() {
        return this.repository.getAll();
    }

    @Override
    @Transactional
    public DomainEnseignant update(Long id, DomainEnseignant domainEnseignant, MultipartFile photoFile) {
        DomainEnseignant existingEnseignant = this.repository.findById(id);

        if (photoFile != null && !photoFile.isEmpty()) {
            String photoFileName = fileStorageService.save(photoFile);
            domainEnseignant.setPhoto(photoFileName);
        } else {
            domainEnseignant.setPhoto(existingEnseignant.getPhoto());
        }

        return this.repository.update(id, domainEnseignant);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
}
