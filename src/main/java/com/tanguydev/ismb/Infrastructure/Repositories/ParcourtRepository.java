package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Gateway.ParcourtRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Mapper.ParcourtMapper;
import com.tanguydev.ismb.Infrastructure.Models.Etudiant;
import com.tanguydev.ismb.Infrastructure.Models.ParcourtEtudiant;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParcourtRepository implements ParcourtRepositoryInterface {
    private final ParcourtJpaRepository parcourtJpaRepository;
    private final EtudiantMapper mapper;

    public ParcourtRepository(ParcourtJpaRepository parcourtJpaRepository, EtudiantMapper mapper) {
        this.parcourtJpaRepository = parcourtJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DomainEtudiant> findEtudiantsByFiliereAndAnee( Long filiereId, Long anneeScolaireId) {
        List<ParcourtEtudiant> parcours = parcourtJpaRepository.findByFiliereIdAndAnneeScolaireId(filiereId, anneeScolaireId);
        List<Etudiant> etudiants = parcours.stream()
                .map(ParcourtEtudiant::getEtudiant)
                .toList();
        System.out.println("Les etudiants recuperes"+etudiants);
        return mapper.toDomainList(etudiants, new CycleAvoidingMappingContext());
    }
}
