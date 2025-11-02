package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

public interface UpdateMatiereUseCaseInterface {
    DomainMatiere execute(Long id, DomainMatiere domainMatiere);
}
