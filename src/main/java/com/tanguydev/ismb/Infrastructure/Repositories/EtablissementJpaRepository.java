package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementJpaRepository extends JpaRepository<Etablissement, Long> {
}
