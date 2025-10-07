package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;
import com.tanguydev.ismb.Domain.Gateway.EtablissementRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.EtablissementMapper;
import com.tanguydev.ismb.Infrastructure.Models.Etablissement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtablissementRepository implements EtablissementRepositoryInterface {
    private final EtablissementJpaRepository repository;
    private final EtablissementMapper mapper;

    public EtablissementRepository(EtablissementJpaRepository repository, EtablissementMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainEtablissement save(DomainEtablissement domainEtablissement) {
        Etablissement jpa = repository.save(mapper.toJPa(domainEtablissement));
        return mapper.toDomain(jpa);
    }

    @Override
    public DomainEtablissement findById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElseThrow(()->new RuntimeException("Etablissement Not Found"));
    }

    @Override
    public List<DomainEtablissement> getAll() {
        List<Etablissement> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList);
    }

    @Override
    public DomainEtablissement update(Long id, DomainEtablissement domainEtablissement) {
        Etablissement existing = repository.findById(id).orElseThrow();
        existing.setNom(domainEtablissement.getNom());
        existing.setEmail(domainEtablissement.getEmail());
        existing.setContact(domainEtablissement.getContact());
        existing.setNumero(domainEtablissement.getNumero());
        return mapper.toDomain(existing);
    }
}
