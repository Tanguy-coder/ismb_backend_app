package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;

public interface UpdateFiliereUseCaseInterface {
    DomainFiliere execute(Long id, DomainFiliere filiere);
}
