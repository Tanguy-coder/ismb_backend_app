package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

import java.util.List;

public interface MatiereServiceInterface {
    DomainMatiere save(DomainMatiere domainMatiere, Long niveauId);
    DomainMatiere findById(Long id);
    List<DomainMatiere> getAll();
    DomainMatiere update(Long id, DomainMatiere domainMatiere);
    void delete(Long id);
}
