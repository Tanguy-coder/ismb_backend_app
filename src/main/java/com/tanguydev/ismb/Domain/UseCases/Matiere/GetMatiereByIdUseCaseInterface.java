package com.tanguydev.ismb.Domain.UseCases.Matiere;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;

public interface GetMatiereByIdUseCaseInterface {
    DomainMatiere execute(Long id);
}
