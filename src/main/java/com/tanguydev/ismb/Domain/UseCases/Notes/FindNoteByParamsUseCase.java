package com.tanguydev.ismb.Domain.UseCases.Notes;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Ports.NoteServiceInterface;

import java.util.List;

public class FindNoteByParamsUseCase implements FindNoteByParamsUseCaseInterface {
    private final NoteServiceInterface noteService;

    public FindNoteByParamsUseCase(NoteServiceInterface noteService) {
        this.noteService = noteService;
    }


    @Override
    public List<DomainNote> findByParams(Long anneeScolaireId, Long filiereId, Long ueId, String session, Integer periode) {
        return this.noteService.findNoteByAnneeFiliereUeSessionPeriode(anneeScolaireId, filiereId, ueId, session, periode);
    }
}
