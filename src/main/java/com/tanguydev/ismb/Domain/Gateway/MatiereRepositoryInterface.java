package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

import java.util.List;

public interface MatiereRepositoryInterface {
    DomainMatiere save(DomainMatiere domainMatiere);
    DomainMatiere findById(Long id);
    List<DomainMatiere> getAll();
    DomainMatiere update(Long id, DomainMatiere domainMatiere);
    void delete(Long id);
}
