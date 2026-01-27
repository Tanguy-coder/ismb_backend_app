package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.ParcourtEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParcourtJpaRepository extends JpaRepository<ParcourtEtudiant, Long> {
    List<ParcourtEtudiant> findByFiliereIdAndAnneeScolaireId (Long filiereId, Long anneeScolaireId);
}
