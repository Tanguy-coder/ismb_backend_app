package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Gateway.FiliereRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.NiveauRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.FiliereServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiliereService implements FiliereServiceInterface {
    private final FiliereRepositoryInterface repository;
    private final NiveauRepositoryInterface niveauRepository;

    public FiliereService(FiliereRepositoryInterface repository, NiveauRepositoryInterface niveauRepository) {
        this.repository = repository;
        this.niveauRepository = niveauRepository;
    }

    @Override
    public DomainFiliere save(DomainFiliere filiere, Long niveauId) {
        DomainNiveau niveau = niveauRepository.findById(niveauId);
        filiere.setNiveau(niveau);
        return this.repository.save(filiere);
    }

    @Override
    public DomainFiliere findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public List<DomainFiliere> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainFiliere update(Long id, DomainFiliere filiere) {
        return this.repository.update(id, filiere);
    }
}
