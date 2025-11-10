package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

import java.util.Set;

public interface CreateMatiereUseCaseInterface {
    DomainMatiere execute(DomainMatiere domainMatiere, Set<Long> niveauIds);
}
