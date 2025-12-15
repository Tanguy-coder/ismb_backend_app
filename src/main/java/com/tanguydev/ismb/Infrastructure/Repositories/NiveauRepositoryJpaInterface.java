package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepositoryJpaInterface extends JpaRepository<Niveau, Long> {
}
