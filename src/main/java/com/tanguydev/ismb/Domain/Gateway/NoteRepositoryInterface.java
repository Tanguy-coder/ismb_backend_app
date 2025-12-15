package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainNote;

import java.util.List;

public interface NoteRepositoryInterface {
    List<DomainNote> store(List<DomainNote> domainNotes);
    List<DomainNote> update(List<DomainNote> domainNotes);
    List<DomainNote> findNoteByAnneeFiliereUeSessionPeriode(Long anneeScolaireId, Long filiereId, Long ueId, String session, Integer periode);
}
