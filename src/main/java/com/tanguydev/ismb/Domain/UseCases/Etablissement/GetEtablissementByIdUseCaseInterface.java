package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;

public interface GetEtablissementByIdUseCaseInterface {
    DomainEtablissement execute(Long id);
}
