package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;

public interface GetNiveauByIdUseCaseInterface {
    DomainNiveau execute(Long id);
}
