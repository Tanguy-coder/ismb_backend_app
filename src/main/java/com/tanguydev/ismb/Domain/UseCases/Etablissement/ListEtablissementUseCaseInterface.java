package com.tanguydev.ismb.Domain.UseCases.Etablissement;

import com.tanguydev.ismb.Domain.Entity.DomainEtablissement;

import java.util.List;

public interface ListEtablissementUseCaseInterface {
    List<DomainEtablissement> execute();
}
