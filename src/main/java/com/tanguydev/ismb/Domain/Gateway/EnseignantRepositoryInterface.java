package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;

import java.util.List;

public interface EnseignantRepositoryInterface {

    DomainEnseignant save(DomainEnseignant domainEnseignant);

    DomainEnseignant findById(Long id);

    List<DomainEnseignant> getAll();

    DomainEnseignant update(Long id, DomainEnseignant domainEnseignant);

    void delete(Long id);

}
