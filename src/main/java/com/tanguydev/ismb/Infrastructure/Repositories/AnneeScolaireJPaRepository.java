package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.AnneeScolaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnneeScolaireJPaRepository extends JpaRepository<AnneeScolaire, Long> {
    Optional<AnneeScolaire> findByCode(String code);
    Optional<AnneeScolaire> findTopByOrderByCodeDesc();
}
