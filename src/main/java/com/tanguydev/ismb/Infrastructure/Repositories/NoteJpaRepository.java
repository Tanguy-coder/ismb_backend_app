package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.AnneeScolaire;
import com.tanguydev.ismb.Infrastructure.Models.Filiere;
import com.tanguydev.ismb.Infrastructure.Models.Note;
import com.tanguydev.ismb.Infrastructure.Models.Ue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteJpaRepository extends JpaRepository<Note, Long> {

    List<Note> findByAnneeScolaireAndFiliereAndUeAndSessionAndPeriode(
            AnneeScolaire anneeScolaire,
            Filiere filiere,
            Ue ue,
            String session,
            Integer periode
    );

    boolean existsByEtudiantIdAndAnneeScolaireIdAndUeIdAndFiliereIdAndSessionAndPeriode(
            Long etudiantId,
            Long anneeId,
            Long ueId,
            Long filiereId,
            String session,
            Integer periode
    );


}
