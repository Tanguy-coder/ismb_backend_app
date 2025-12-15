package com.tanguydev.ismb.Domain.UseCases.Notes;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import java.util.List;

public interface CreateNoteUseCaseInterface {
    List<DomainNote> execute(List<DomainNote> domainNotes);
}
