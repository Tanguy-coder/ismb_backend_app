package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Gateway.MatiereRepositoryInterface;
import com.tanguydev.ismb.Domain.Gateway.NiveauRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.MatiereServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService implements MatiereServiceInterface {

    private final MatiereRepositoryInterface matiereRepository;
    private final NiveauRepositoryInterface niveauRepository;

    public MatiereService(MatiereRepositoryInterface matiereRepository, NiveauRepositoryInterface niveauRepository) {
        this.matiereRepository = matiereRepository;
        this.niveauRepository = niveauRepository;
    }

    @Override
    public DomainMatiere save(DomainMatiere domainMatiere, Long niveauId) {
        DomainNiveau niveau = niveauRepository.findById(niveauId);
        domainMatiere.setNiveau(niveau);
        return matiereRepository.save(domainMatiere);
    }

    @Override
    public DomainMatiere findById(Long id) {
        return matiereRepository.findById(id);
    }

    @Override
    public List<DomainMatiere> getAll() {
        return matiereRepository.getAll();
    }

    @Override
    public DomainMatiere update(Long id, DomainMatiere domainMatiere) {
        return matiereRepository.update(id, domainMatiere);
    }

    @Override
    public void delete(Long id) {
        matiereRepository.delete(id);
    }
}