package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.*;
import com.tanguydev.ismb.Domain.Gateway.AnneeScolaireRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.EtudiantRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.FiliereRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.RoleRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.EtudiantServiceInterface;
import com.tanguydev.ismb.Domain.Ports.FileStorageServiceInterface;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EtudiantService implements EtudiantServiceInterface {
    private final EtudiantRepositoryInterface repository;
    private final FileStorageServiceInterface fileStorageService;
    private final UserServiceInterface userService;
    private final RoleRepositoryInterface roleRepository;
    private final FiliereRepositoryInterface filiereRepository;
    private final AnneeScolaireRepositoryInterface anneeScolaireRepository;


    public EtudiantService(EtudiantRepositoryInterface repository, FileStorageServiceInterface fileStorageService, UserServiceInterface userService, RoleRepositoryInterface roleRepository, FiliereRepositoryInterface filiereRepository, AnneeScolaireRepositoryInterface anneeScolaireRepository) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.filiereRepository = filiereRepository;
        this.anneeScolaireRepository = anneeScolaireRepository;
    }

    @Override
    @Transactional
    public DomainEtudiant save(DomainEtudiant domainEtudiant, MultipartFile photoFile, Long filiereId, String statut) {

        DomainUser userToCreate = domainEtudiant.getUser();

        if (userToCreate.getRoles() == null || userToCreate.getRoles().isEmpty()) {
            DomainRole userRole = roleRepository.findByName(ERole.User.name()).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            Set<DomainRole> roles = new HashSet<>();
            roles.add(userRole);
            userToCreate.setRoles(roles);
        }

        DomainUser createdUser = userService.save(userToCreate);
        domainEtudiant.setUser(createdUser);

        String photoFileName = fileStorageService.save(photoFile);
        domainEtudiant.setPhoto(photoFileName);

        // Create ParcourtEtudiant
        DomainParcourtEtudiant parcourtEtudiant = new DomainParcourtEtudiant();
        parcourtEtudiant.setStatut(statut);

        DomainAnneeScolaire anneeScolaire = anneeScolaireRepository.findLastRegisteredAnneeScolaire()
                .orElseThrow(()->new RuntimeException("Aucune annéé scolaire trouvée"));
        parcourtEtudiant.setAnneeScolaire(anneeScolaire);

        // Set Filiere for ParcourtEtudiant
        DomainFiliere filiere = filiereRepository.findById(filiereId);

        parcourtEtudiant.setFiliere(filiere);

        parcourtEtudiant.setEtudiant(domainEtudiant);

        // Add parcourtEtudiant to the student's parcours set
        if (domainEtudiant.getParcours() == null) {
            domainEtudiant.setParcours(new HashSet<>());
        }
        domainEtudiant.getParcours().add(parcourtEtudiant);

        return this.repository.save(domainEtudiant);
    }

    @Override
    public DomainEtudiant findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<DomainEtudiant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainEtudiant update(Long id, DomainEtudiant domainEtudiant, MultipartFile photoFile) {
        // Retrieve existing student to handle photo update
        DomainEtudiant existingEtudiant = this.repository.findById(id);

        // Handle photo update
        if (photoFile != null && !photoFile.isEmpty()) {
            String photoFileName = fileStorageService.save(photoFile);
            domainEtudiant.setPhoto(photoFileName);
        } else {
            // If no new photo is provided, retain the old one
            domainEtudiant.setPhoto(existingEtudiant.getPhoto());
        }

        return this.repository.update(id, domainEtudiant);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }
}
