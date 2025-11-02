package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;

import java.util.List;

public interface FiliereServiceInterface {
    DomainFiliere save(DomainFiliere filiere, Long niveauId);
    DomainFiliere findById(Long id);
    List<DomainFiliere> getAll();
    DomainFiliere update(Long id, DomainFiliere filiere);
}
