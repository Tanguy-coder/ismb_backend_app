package com.tanguydev.ismb.Domain.UseCases.Etudiant;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;

import java.util.List;

public interface ListEtudiantUseCaseInterface {
    List<DomainEtudiant> execute();
}
