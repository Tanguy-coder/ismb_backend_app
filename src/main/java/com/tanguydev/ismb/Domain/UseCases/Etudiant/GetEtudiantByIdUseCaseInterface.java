package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;

public interface GetEtudiantByIdUseCaseInterface {
    DomainEtudiant execute(Long id);
}
