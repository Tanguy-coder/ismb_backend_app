package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

import java.util.Set;

public interface UpdateMatiereUseCaseInterface {
    DomainMatiere execute(Long id, DomainMatiere domainMatiere, Set<Long> niveauIds);
}
