package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Gateway.AnneeScolaireRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.AnneeScolaireServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeScolaireService implements AnneeScolaireServiceInterface {
    private final AnneeScolaireRepositoryInterface repository;

    public AnneeScolaireService(AnneeScolaireRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public DomainAnneeScolaire save(DomainAnneeScolaire anneeScolaire) {
        return this.repository.save(anneeScolaire);
    }

    @Override
    public DomainAnneeScolaire getById(Long id) {
        return this.repository.getById(id);
    }

    @Override
    public List<DomainAnneeScolaire> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainAnneeScolaire update(Long id, DomainAnneeScolaire anneeScolaire) {
        return this.repository.update(id, anneeScolaire);
    }
}
