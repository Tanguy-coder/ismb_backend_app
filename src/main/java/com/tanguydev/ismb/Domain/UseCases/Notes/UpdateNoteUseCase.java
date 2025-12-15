package com.tanguydev.ismb.Domain.UseCases.Notes;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Ports.NoteServiceInterface;

import java.util.List;

public class UpdateNoteUseCase implements UpdateNoteUseCaseInterface {

    private final NoteServiceInterface noteService;

    public UpdateNoteUseCase(NoteServiceInterface noteService) {
        this.noteService = noteService;
    }

    @Override
    public List<DomainNote> execute(List<DomainNote> domainNotes) {
        return List.of();
    }
}
