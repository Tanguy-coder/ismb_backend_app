package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantJpaRepository extends JpaRepository<Etudiant, Long> {
}
