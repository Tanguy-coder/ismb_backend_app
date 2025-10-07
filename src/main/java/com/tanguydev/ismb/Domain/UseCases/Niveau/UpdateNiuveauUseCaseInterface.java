package com.tanguydev.ismb.Domain.UseCases.Niveau;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;

public interface UpdateNiuveauUseCaseInterface {
    DomainNiveau execute(Long id, DomainNiveau niveau);
}
