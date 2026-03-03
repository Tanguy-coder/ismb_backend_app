package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Exception.DuplicateResourceException;
import com.tanguydev.ismb.Domain.Gateway.EtudiantRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDate;

@Repository
public class EtudiantRepository implements EtudiantRepositoryInterface {
    private final EtudiantJpaRepository repository;
    private final EtudiantMapper mapper;

    public EtudiantRepository(EtudiantJpaRepository repository, EtudiantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainEtudiant save(DomainEtudiant domainEtudiant) {
        Etudiant etudiant = mapper.toJpa(domainEtudiant, new CycleAvoidingMappingContext());

        if (etudiant.getMatricule() == null || etudiant.getMatricule().trim().isEmpty()) {
            etudiant.setMatricule(generateMatriculeByYearAndNextId());
        } else {
            // Vérifier si le matricule existe déjà
            if (repository.existsByMatricule(etudiant.getMatricule())) {
                throw new DuplicateResourceException("Etudiant", "matricule", etudiant.getMatricule());
            }
        }

        Etudiant savedEtudiant = repository.save(etudiant);
        return mapper.toDomain(savedEtudiant, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEtudiant findById(Long id) {
        return repository.findById(id).map(
                etudiant -> mapper.toDomain(etudiant,
                        new CycleAvoidingMappingContext())).orElseThrow(
                                () -> new RuntimeException("Etudiant not found")
        );
    }

    @Override
    public List<DomainEtudiant> getAll() {
        List<Etudiant> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEtudiant update(Long id, DomainEtudiant domainEtudiant) {
        Etudiant existingEtudiant = repository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));

        Etudiant updatedEtudiantData = mapper.toJpa(domainEtudiant, new CycleAvoidingMappingContext());
        
        existingEtudiant.setSexe(updatedEtudiantData.getSexe());
        // Mettre à jour le matricule s'il est fourni explicitement, sinon le générer si absent côté base
        if (updatedEtudiantData.getMatricule() != null && !updatedEtudiantData.getMatricule().trim().isEmpty()) {
            // Vérifier si le nouveau matricule existe déjà (sur un autre étudiant)
            if (!updatedEtudiantData.getMatricule().equals(existingEtudiant.getMatricule()) && 
                repository.existsByMatricule(updatedEtudiantData.getMatricule())) {
                throw new DuplicateResourceException("Etudiant", "matricule", updatedEtudiantData.getMatricule());
            }
            existingEtudiant.setMatricule(updatedEtudiantData.getMatricule());
        } else if (existingEtudiant.getMatricule() == null || existingEtudiant.getMatricule().trim().isEmpty()) {
            existingEtudiant.setMatricule(generateMatriculeByYearAndNextId());
        }
        existingEtudiant.setDateNaissance(updatedEtudiantData.getDateNaissance());
        existingEtudiant.setLieuNaissance(updatedEtudiantData.getLieuNaissance());
        existingEtudiant.setTelephone(updatedEtudiantData.getTelephone());
        existingEtudiant.setNationalite(updatedEtudiantData.getNationalite());
        existingEtudiant.setFiliere(updatedEtudiantData.getFiliere());
        existingEtudiant.setPhoto(updatedEtudiantData.getPhoto());
        existingEtudiant.setAttentes(updatedEtudiantData.getAttentes());

        Etudiant updatedJpa = repository.save(existingEtudiant);
        return mapper.toDomain(updatedJpa, new CycleAvoidingMappingContext());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private String generateMatriculeByYearAndNextId() {
        int year = LocalDate.now().getYear();
        Etudiant last = repository.findTopByOrderByIdDesc();
        long nextId = (last != null && last.getId() != null) ? last.getId() + 1 : 1L;

        String matricule = buildMatricule(year, nextId);
        int attempts = 0;
        while (repository.existsByMatricule(matricule)) {
            nextId++;
            matricule = buildMatricule(year, nextId);
            attempts++;
            if (attempts > 1000) {
                throw new IllegalStateException("Impossible de générer un matricule unique après 1000 tentatives");
            }
        }
        return matricule;
    }

    private String buildMatricule(int year, long id) {
        return "ETU" + year + id;
    }
}
