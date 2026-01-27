package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;

import java.util.List;

public interface ParcourtServiceInterface {
    List<DomainEtudiant> listeClasse(Long filiereId, Long anneeScolaireId);
}
