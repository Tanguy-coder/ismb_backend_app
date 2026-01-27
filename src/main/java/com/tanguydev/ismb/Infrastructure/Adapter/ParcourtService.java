package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Gateway.ParcourtRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.ParcourtServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcourtService implements ParcourtServiceInterface {
    private final ParcourtRepositoryInterface repository;

    public ParcourtService(ParcourtRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEtudiant> listeClasse( Long filiereId, Long anneeScolaireId) {
        return this.repository.findEtudiantsByFiliereAndAnee( filiereId, anneeScolaireId);
    }
}
