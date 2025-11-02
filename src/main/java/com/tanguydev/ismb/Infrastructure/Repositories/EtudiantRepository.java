package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Gateway.EtudiantRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
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
        Etudiant etudiant = mapper.toJpa(domainEtudiant, new CycleAvoidingMappingContext());
        Etudiant savedEtudiant = repository.save(etudiant);
        return mapper.toDomain(savedEtudiant, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEtudiant findById(Long id) {
        return repository.findById(id).map(etudiant -> mapper.toDomain(etudiant, new CycleAvoidingMappingContext())).orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }

    @Override
    public List<DomainEtudiant> getAll() {
        List<Etudiant> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList, new CycleAvoidingMappingContext());
    }

    @Override
    public DomainEtudiant update(Long id, DomainEtudiant domainEtudiant) {
        Etudiant existingEtudiant = repository.findById(id).orElseThrow(() -> new RuntimeException("Etudiant not found"));
        // For a full update, you might map the domain object to the existing JPA entity
        Etudiant updatedEtudiantData = mapper.toJpa(domainEtudiant, new CycleAvoidingMappingContext());
        
        // Manually update non-relation fields to avoid issues with managed entities
        existingEtudiant.setSexe(updatedEtudiantData.getSexe());
        existingEtudiant.setDateNaissance(updatedEtudiantData.getDateNaissance());
        existingEtudiant.setLieuNaissance(updatedEtudiantData.getLieuNaissance());
        existingEtudiant.setTelephone(updatedEtudiantData.getTelephone());
        existingEtudiant.setNationalite(updatedEtudiantData.getNationalite());
        existingEtudiant.setFiliereInt(updatedEtudiantData.getFiliereInt());
        existingEtudiant.setPhoto(updatedEtudiantData.getPhoto());
        existingEtudiant.setAttentes(updatedEtudiantData.getAttentes());

        // You might need to handle collections carefully, e.g., clearing and adding
        // Or handle updates within the collections themselves

        Etudiant updatedJpa = repository.save(existingEtudiant);
        return mapper.toDomain(updatedJpa, new CycleAvoidingMappingContext());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
