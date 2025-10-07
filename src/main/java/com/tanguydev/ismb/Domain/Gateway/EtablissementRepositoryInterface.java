package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;

import java.util.List;

public interface EtablissementRepositoryInterface {
    DomainEtablissement save(DomainEtablissement domainEtablissement);
    DomainEtablissement findById(Long id);
    List<DomainEtablissement> getAll();
    DomainEtablissement update(Long id, DomainEtablissement domainEtablissement);
}
