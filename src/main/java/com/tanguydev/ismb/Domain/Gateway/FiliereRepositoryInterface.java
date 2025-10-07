package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;

import java.util.List;

public interface FiliereRepositoryInterface {
    DomainFiliere save(DomainFiliere filiere);
    DomainFiliere findById(Long id);
    List<DomainFiliere> getAll();
    DomainFiliere update(Long id, DomainFiliere filiere);
}
