package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Gateway.EnseignantRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.EnseignantMapper;
import com.tanguydev.ismb.Infrastructure.Models.Enseignant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnseignantRepository implements EnseignantRepositoryInterface {
    private final EnseignantJpaRepository repository;
    private final EnseignantMapper mapper;

    public EnseignantRepository(EnseignantJpaRepository repository, EnseignantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainEnseignant save(DomainEnseignant domainEnseignant) {
        Enseignant enseignant = mapper.toJpa(domainEnseignant, new CycleAvoidingMappingContext());
        Enseignant savedEnseignant = repository.save(enseignant);
        return mapper.toDomain(savedEnseignant, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEnseignant findById(Long id) {
        return repository.findById(id).map(enseignant -> mapper.toDomain(enseignant, new CycleAvoidingMappingContext())).orElseThrow(() -> new RuntimeException("Enseignant not found"));
    }

    @Override
    public List<DomainEnseignant> getAll() {
        List<Enseignant> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEnseignant update(Long id, DomainEnseignant domainEnseignant) {
        Enseignant existingEnseignant = repository.findById(id).orElseThrow(() -> new RuntimeException("Enseignant not found"));
        
        Enseignant updatedEnseignantData = mapper.toJpa(domainEnseignant, new CycleAvoidingMappingContext());
        
        existingEnseignant.setSexe(updatedEnseignantData.getSexe());
        existingEnseignant.setDateNaissance(updatedEnseignantData.getDateNaissance());
        existingEnseignant.setLieuNaissance(updatedEnseignantData.getLieuNaissance());
        existingEnseignant.setTelephone(updatedEnseignantData.getTelephone());
        existingEnseignant.setNationalite(updatedEnseignantData.getNationalite());
        existingEnseignant.setPhoto(updatedEnseignantData.getPhoto());
        existingEnseignant.setMatiere(updatedEnseignantData.getMatiere()); // Add this line

        Enseignant updatedJpa = repository.save(existingEnseignant);
        return mapper.toDomain(updatedJpa, new CycleAvoidingMappingContext());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
