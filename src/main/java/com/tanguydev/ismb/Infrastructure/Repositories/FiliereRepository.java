package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Gateway.FiliereRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.FiliereMapper;
import com.tanguydev.ismb.Infrastructure.Models.Filiere;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FiliereRepository implements FiliereRepositoryInterface {
    private final FiliereJpaRepository repository;
    private final FiliereMapper mapper;

    public FiliereRepository(FiliereJpaRepository repository, FiliereMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainFiliere save(DomainFiliere domainFiliere) {
        Filiere jpa = repository.save(mapper.toJpa(domainFiliere));
        return mapper.toDomain(jpa);
    }

    @Override
    public DomainFiliere findById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElseThrow(() -> new RuntimeException("Filiere not found"));
    }

    @Override
    public List<DomainFiliere> getAll() {
        List<Filiere> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList);
    }

    @Override
    public DomainFiliere update(Long id, DomainFiliere domainFiliere) {
        Filiere existingFiliere = repository.findById(id).orElseThrow(() -> new RuntimeException("Filiere not found"));
        existingFiliere.setLibelle(domainFiliere.getLibelle());
        existingFiliere.setDescription(domainFiliere.getDescription());
        // Handle Niveau relation update
        if (domainFiliere.getNiveau() != null && domainFiliere.getNiveau().getId() != null) {
            existingFiliere.setNiveau(mapper.mapNiveau(domainFiliere.getNiveau().getId()));
        }
        Filiere updatedJpa = repository.save(existingFiliere);
        return mapper.toDomain(updatedJpa);
    }
}