package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Gateway.AnneeScolaireRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.AnneeScolaireMapper;
import com.tanguydev.ismb.Infrastructure.Models.AnneeScolaire;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnneeScolaireRepository implements AnneeScolaireRepositoryInterface {
    private final AnneeScolaireJPaRepository repository;
    private final AnneeScolaireMapper mapper;

    public AnneeScolaireRepository(AnneeScolaireJPaRepository repository, AnneeScolaireMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DomainAnneeScolaire save(DomainAnneeScolaire anneeScolaire) {
        AnneeScolaire jpa = repository.save(mapper.toJpa(anneeScolaire));
        return mapper.toDomain(jpa);
    }

    @Override
    public DomainAnneeScolaire getById(Long id) {
        return repository.findById(id).map(mapper::toDomain).orElseThrow();
    }

    @Override
    public List<DomainAnneeScolaire> getAll() {
        List<AnneeScolaire> jpaList = repository.findAll();
        return mapper.toDomainList(jpaList);
    }

    @Override
    public DomainAnneeScolaire update(Long id, DomainAnneeScolaire anneeScolaire) {
        AnneeScolaire existing = repository.findById(id).orElseThrow();
        existing.setCode(anneeScolaire.getCode());
        existing.setDateDebut(anneeScolaire.getDateDebut());
        existing.setDateFin(anneeScolaire.getDateFin());
        return mapper.toDomain(existing);
    }
}
