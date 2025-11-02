package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

public interface CreateMatiereUseCaseInterface {
    DomainMatiere execute(DomainMatiere domainMatiere, Long niveauId);
}
