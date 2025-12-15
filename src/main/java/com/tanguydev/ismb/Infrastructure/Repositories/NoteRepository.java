package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Gateway.NoteRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.Context.CycleAvoidingMappingContext;
import com.tanguydev.ismb.Infrastructure.Mapper.NoteMapper;
import com.tanguydev.ismb.Infrastructure.Models.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteRepository implements NoteRepositoryInterface {

    private final NoteJpaRepository repository;
    private final NoteMapper mapper;
    private final EntityManager em;

    public NoteRepository(NoteJpaRepository repository, NoteMapper mapper, EntityManager em) {
        this.repository = repository;
        this.mapper = mapper;
        this.em = em;
    }

    @Override
    @Transactional
    public List<DomainNote> store(List<DomainNote> domainNotes) {
        List<Note> preparedNotes = new ArrayList<>();

        for (int i = 0; i < domainNotes.size(); i++) {
            DomainNote d = domainNotes.get(i);

            if (d.getAnneeScolaire() == null || d.getAnneeScolaire().getId() == null)
                throw new IllegalArgumentException("anneeScolaire.id est requis");
            if (d.getEtudiant() == null || d.getEtudiant().getId() == null)
                throw new IllegalArgumentException("etudiant.id est requis");
            if (d.getUe() == null || d.getUe().getId() == null)
                throw new IllegalArgumentException("ue.id est requis");
            if (d.getFiliere() == null || d.getFiliere().getId() == null)
                throw new IllegalArgumentException("filiere.id est requis");

            // --- Vérification si la note existe déjà ---
            boolean exists = repository.existsByEtudiantIdAndAnneeScolaireIdAndUeIdAndFiliereIdAndSessionAndPeriode(
                    d.getEtudiant().getId(),
                    d.getAnneeScolaire().getId(),
                    d.getUe().getId(),
                    d.getFiliere().getId(),
                    d.getSession(),
                    d.getPeriode()
            );

            if (exists) {
                System.out.println("Note déjà existante pour l'étudiant : " + d.getEtudiant().getId());
                continue;
            }

            // --- Mapper vers JPA ---
            Note jpaNote = mapper.toJpa(d, new CycleAvoidingMappingContext());

            // --- Rattachement des références ---
            jpaNote.setAnneeScolaire(em.getReference(AnneeScolaire.class, d.getAnneeScolaire().getId()));
            jpaNote.setEtudiant(em.getReference(Etudiant.class, d.getEtudiant().getId()));
            jpaNote.setUe(em.getReference(Ue.class, d.getUe().getId()));
            jpaNote.setFiliere(em.getReference(Filiere.class, d.getFiliere().getId()));

            // --- Calcul des moyennes ---
            Float cc = jpaNote.getCc() == null ? 0 : jpaNote.getCc();
            Float tp = jpaNote.getTp() == null ? 0 : jpaNote.getTp();
            Float examen = jpaNote.getExamen() == null ? 0 : jpaNote.getExamen();

            jpaNote.setMoyenne((cc + tp + examen) / 3f);
            jpaNote.setMention(Mention(jpaNote.getMoyenne()));

            preparedNotes.add(jpaNote);
        }

        if (preparedNotes.isEmpty()) {
            return List.of(); // rien à sauvegarder
        }

        List<Note> savedNotes = repository.saveAll(preparedNotes);

        return mapper.toDomainList(savedNotes, new CycleAvoidingMappingContext());
    }

    @Override
    public List<DomainNote> update(List<DomainNote> domainNotes) {
       if(domainNotes == null || domainNotes.isEmpty())
       {
           return List.of();
       }

       List<DomainNote> updatedDomaineNotes = new ArrayList<>();

       for (DomainNote d : domainNotes) {
           Note existingNote = em.find(Note.class, d.getId());

           if (existingNote == null) {
               throw new EntityNotFoundException("Note avec ID " + d.getId() + " introuvable");
           }
           existingNote.setCc(d.getCc());
           existingNote.setTp(d.getTp());
           existingNote.setExamen(d.getExamen());
           existingNote.setMention(d.getMention());
           existingNote.setMoyenne(d.getMoyenne());

           existingNote.setAnneeScolaire(em.getReference(AnneeScolaire.class, d.getAnneeScolaire().getId()));
           existingNote.setEtudiant(em.getReference(Etudiant.class, d.getEtudiant().getId()));
           existingNote.setUe(em.getReference(Ue.class, d.getUe().getId()));
           existingNote.setFiliere(em.getReference(Filiere.class, d.getFiliere().getId()));

           Note updatedNote = em.merge(existingNote);
           updatedDomaineNotes.add(mapper.toDomain(updatedNote, new CycleAvoidingMappingContext()));
       }
        return updatedDomaineNotes;
    }


    @Override
    public List<DomainNote> findNoteByAnneeFiliereUeSessionPeriode(Long anneeScolaireId, Long filiereId, Long ueId, String session, Integer periode) {
        if (anneeScolaireId == null) throw new IllegalArgumentException("anneeScolaireId est requis");
        if (filiereId == null) throw new IllegalArgumentException("filiereId est requis");
        if (ueId == null) throw new IllegalArgumentException("ueId est requis");
        if (session == null || session.isBlank()) throw new IllegalArgumentException("session est requise");
        if (periode == null) throw new IllegalArgumentException("periode est requis");

        AnneeScolaire anneeRef = em.getReference(AnneeScolaire.class, anneeScolaireId);
        Filiere filiereRef = em.getReference(Filiere.class, filiereId);
        Ue ueRef = em.getReference(Ue.class, ueId);

        List<Note> results = repository.findByAnneeScolaireAndFiliereAndUeAndSessionAndPeriode(
                anneeRef,
                filiereRef,
                ueRef,
                session,
                periode
        );
        return mapper.toDomainList(results, new CycleAvoidingMappingContext());
    }

    private static String Mention(Float moyenne){
        if (moyenne == null) throw new IllegalArgumentException("notes requises");
        if (moyenne < 10)
            return "Faible";
        if (moyenne < 12)
            return "Passable";
        if (moyenne < 14)
            return "Assez-Bien";
        if (moyenne < 16)
            return "Bien";
        if (moyenne < 19)
            return "Très-Bien";

        return "Excellent";
    }


}
