package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Gateway.NiveauRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.NiveauMapper;
import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NiveauRepository implements NiveauRepositoryInterface {
    private final NiveauRepositoryJpaInterface repository;
    private final NiveauMapper mapper;

    public NiveauRepository(NiveauRepositoryJpaInterface repository, NiveauMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainNiveau save(DomainNiveau domainNiveau) {
        Niveau jpa = repository.save(mapper.toJpa(domainNiveau));
        return mapper.toDomain(jpa);
    }

    @Override
    public List<DomainNiveau> getAll() {
        List<Niveau> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList);
    }

    @Override
    public DomainNiveau findById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElseThrow(() -> new RuntimeException("Niveau not found"));
    }

    @Override
    public DomainNiveau update(Long id, DomainNiveau domainNiveau) {
        Niveau existingNiveau = repository.findById(id).orElseThrow(() -> new RuntimeException("Niveau not found"));
        existingNiveau.setLibelle(domainNiveau.getLibelle());
        // Relations (filieres, etudiants, ues, parcours) are not updated directly here
        Niveau updatedJpa = repository.save(existingNiveau);
        return mapper.toDomain(updatedJpa);
    }
}