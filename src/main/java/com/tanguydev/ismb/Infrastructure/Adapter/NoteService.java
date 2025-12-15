package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Gateway.NoteRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.NoteServiceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NoteService implements NoteServiceInterface {

    private final NoteRepositoryInterface repository;

    public NoteService(NoteRepositoryInterface repository) {
        this.repository = repository;
    }


    @Override
    public List<DomainNote> store(List<DomainNote> domainNotes) {
        return this.repository.store(domainNotes);
    }

    @Override
    public List<DomainNote> update(List<DomainNote> domainNotes) {
        return this.repository.update(domainNotes);
    }


    @Override
    public List<DomainNote> findNoteByAnneeFiliereUeSessionPeriode(Long anneeScolaireId, Long filiereId, Long ueId, String session, Integer periode) {
        return this.repository.findNoteByAnneeFiliereUeSessionPeriode(anneeScolaireId, filiereId, ueId, session, periode);
    }


}
