package com.tanguydev.ismb.Infrastructure.Presenter;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Presenter.NotePresenterInterface;
import com.tanguydev.ismb.Domain.Response.NoteResponse;
import com.tanguydev.ismb.Infrastructure.Mapper.NoteMapper;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class NotePresenter implements NotePresenterInterface {
    private final NoteMapper mapper;

    public NotePresenter(NoteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public NoteResponse present(DomainNote note) {
        return mapper.toResponse(note);
    }

    @Override
    public List<NoteResponse> presentList(List<DomainNote> notes) {
        return mapper.toResponseList(notes);
    }
}
