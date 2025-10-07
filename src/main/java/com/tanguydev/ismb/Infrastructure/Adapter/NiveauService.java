package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Gateway.NiveauRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.NiveauServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService implements NiveauServiceInterface {
    private final NiveauRepositoryInterface repository;

    public NiveauService(NiveauRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public DomainNiveau save(DomainNiveau niveau) {
        return this.repository.save(niveau);
    }

    @Override
    public List<DomainNiveau> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DomainNiveau findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    public DomainNiveau update(Long id, DomainNiveau niveau) {
        return this.repository.update(id, niveau);
    }
}
