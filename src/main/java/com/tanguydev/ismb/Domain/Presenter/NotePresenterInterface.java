package com.tanguydev.ismb.Domain.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Response.NoteResponse;

import java.util.List;

public interface NotePresenterInterface {
    NoteResponse present(DomainNote note);
    List<NoteResponse> presentList(List<DomainNote> notes);
}
