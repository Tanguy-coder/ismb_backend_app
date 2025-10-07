package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Gateway.EtudiantRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        Etudiant jpa = repository.save(mapper.toJpa(domainEtudiant));
        return mapper.toDomain(jpa);
    }

    @Override
    public DomainEtudiant findById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }

    @Override
    public List<DomainEtudiant> getAll() {
        List<Etudiant> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList);
    }

    @Override
    public DomainEtudiant update(Long id, DomainEtudiant domainEtudiant) {
        Etudiant existingEtudiant = repository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
        // Update fields from domainEtudiant to existingEtudiant
        existingEtudiant.setSexe(domainEtudiant.getSexe());
        existingEtudiant.setDateNaissance(domainEtudiant.getDateNaissance());
        existingEtudiant.setTelephone(domainEtudiant.getTelephone());
        existingEtudiant.setNationalite(domainEtudiant.getNationalite());
        existingEtudiant.setPhoto(domainEtudiant.getPhoto());
        existingEtudiant.setAttentes(domainEtudiant.getAttentes());
        // Handle relations (User and Niveau) if they are updated
        if (domainEtudiant.getUser() != null && domainEtudiant.getUser().getId() != null) {
            existingEtudiant.setUser(mapper.map(domainEtudiant.getUser().getId()));
        }
        if (domainEtudiant.getNiveau() != null && domainEtudiant.getNiveau().getId() != null) {
            existingEtudiant.setNiveau(mapper.mapNiveau(domainEtudiant.getNiveau().getId()));
        }

        Etudiant updatedJpa = repository.save(existingEtudiant);
        return mapper.toDomain(updatedJpa);
    }
}
