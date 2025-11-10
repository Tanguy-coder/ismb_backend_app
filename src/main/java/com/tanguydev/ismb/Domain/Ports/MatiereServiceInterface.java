package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

import java.util.List;
import java.util.Set;

public interface MatiereServiceInterface {
    DomainMatiere save(DomainMatiere domainMatiere, Set<Long> niveauIds);
    DomainMatiere findById(Long id);
    List<DomainMatiere> getAll();
    DomainMatiere update(Long id, DomainMatiere domainMatiere);
    void delete(Long id);
}
