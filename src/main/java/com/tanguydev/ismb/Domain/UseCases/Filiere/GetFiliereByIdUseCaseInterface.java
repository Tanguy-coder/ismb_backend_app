package com.tanguydev.ismb.Domain.UseCases.Filiere;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;

public interface GetFiliereByIdUseCaseInterface {
    DomainFiliere execute(Long id);
}
