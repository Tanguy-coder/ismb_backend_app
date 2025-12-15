package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Gateway.UeRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.UeMapper;
import com.tanguydev.ismb.Infrastructure.Models.Ue;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UeRepository implements UeRepositoryInterface {

    private final UeJPaRepository repository;
    private final UeMapper mapper;

    public UeRepository(UeJPaRepository repository, UeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainUe save(DomainUe domainUe) {
        Ue ue = mapper.toJpa(domainUe, new CycleAvoidingMappingContext());
        ue.setCode(generatedCode());
        return mapper.toDomain(repository.save(ue), new CycleAvoidingMappingContext());
    }

    @Override
    public DomainUe findById(Long id) {
        return repository.findById(id).map(ue -> mapper.toDomain(ue, new CycleAvoidingMappingContext())).orElse(null);
    }

    @Override
    public List<DomainUe> getAll() {
        return repository.findAll().stream()
                .map(ue -> mapper.toDomain(ue, new CycleAvoidingMappingContext()))
                .collect(Collectors.toList());
    }

    @Override
    public DomainUe update(Long id, DomainUe domainUe) {
        Ue existingUe = repository.findById(id).orElseThrow(() -> new RuntimeException("Ue not found"));
        Ue ueToUpdate = mapper.toJpa(domainUe, new CycleAvoidingMappingContext());
        ueToUpdate.setCode(existingUe.getCode());
        ueToUpdate.setId(existingUe.getId());
        return mapper.toDomain(repository.save(ueToUpdate), new CycleAvoidingMappingContext());
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private String generatedCode() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
