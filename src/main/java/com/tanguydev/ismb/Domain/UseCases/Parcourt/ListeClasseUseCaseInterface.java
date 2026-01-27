package com.tanguydev.ismb.Domain.UseCases.Parcourt;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;

import java.util.List;

public interface ListeClasseUseCaseInterface {
    List<DomainEtudiant> execute( Long filiereId, Long anneeScolaireId);
}
