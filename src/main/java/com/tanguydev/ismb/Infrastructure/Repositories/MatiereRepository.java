package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Gateway.MatiereRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.MatiereMapper;
import com.tanguydev.ismb.Infrastructure.Models.Matiere;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MatiereRepository implements MatiereRepositoryInterface {

    private final MatiereJpaRepository repository;
    private final MatiereMapper mapper;

    public MatiereRepository(MatiereJpaRepository repository, MatiereMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainMatiere save(DomainMatiere domainMatiere) {
        Matiere matiere = mapper.toJpa(domainMatiere, new CycleAvoidingMappingContext());
        return mapper.toDomain(repository.save(matiere), new CycleAvoidingMappingContext());
    }

    @Override
    public DomainMatiere findById(Long id) {
        return repository.findById(id).map(matiere -> mapper.toDomain(matiere, new CycleAvoidingMappingContext())).orElse(null);
    }

    @Override
    public List<DomainMatiere> getAll() {
        return repository.findAll().stream()
                .map(matiere -> mapper.toDomain(matiere, new CycleAvoidingMappingContext()))
                .collect(Collectors.toList());
    }

    @Override
    public DomainMatiere update(Long id, DomainMatiere domainMatiere) {
        Matiere matiere = mapper.toJpa(domainMatiere, new CycleAvoidingMappingContext());
        matiere.setId(id);
        return mapper.toDomain(repository.save(matiere), new CycleAvoidingMappingContext());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
