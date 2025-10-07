package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;

public interface UpdateEtablissementUseCaseInterface {
    DomainEtablissement execute(Long id, DomainEtablissement domainEtablissement);
}
