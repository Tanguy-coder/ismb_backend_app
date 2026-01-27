package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;

import java.util.List;

public interface ParcourtRepositoryInterface {
    List<DomainEtudiant> findEtudiantsByFiliereAndAnee( Long filiereId, Long anneeScolaireId);
}
