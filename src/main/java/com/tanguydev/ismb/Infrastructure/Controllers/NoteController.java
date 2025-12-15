package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainNote;
import com.tanguydev.ismb.Domain.Presenter.NotePresenterInterface;
import com.tanguydev.ismb.Domain.Response.NoteResponse;
import com.tanguydev.ismb.Domain.UseCases.Notes.CreateNoteUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Notes.FindNoteByParamsUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.Notes.UpdateNoteUseCaseInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.NoteMapper;
import com.tanguydev.ismb.Infrastructure.Request.NoteRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final CreateNoteUseCaseInterface create;
    private final FindNoteByParamsUseCaseInterface find;
    private final UpdateNoteUseCaseInterface update;
    private final NotePresenterInterface presenter;
    private final NoteMapper mapper;

    public NoteController(CreateNoteUseCaseInterface create, FindNoteByParamsUseCaseInterface find, UpdateNoteUseCaseInterface update, NotePresenterInterface presenter, NoteMapper mapper) {
        this.create = create;
        this.find = find;
        this.update = update;
        this.presenter = presenter;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity<List<NoteResponse>> create(@RequestBody  List<NoteRequest> request) {
        System.out.println("++++++++++++++++++++++++ Ce qui vient"+request);
        List<DomainNote> newNotes = mapper.toDomainList(request);
        List<DomainNote> createdNotes = create.execute(newNotes);
        return ResponseEntity.ok(presenter.presentList(createdNotes));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> findByParams(
            @RequestParam("anneeId") Long anneeId,
            @RequestParam("filiereId") Long filiereId,
            @RequestParam("ueId") Long ueId,
            @RequestParam("session") String session,
            @RequestParam("periode") Integer periode
    ) {
        System.out.println(anneeId);
        List<DomainNote> notes = find.findByParams(anneeId, filiereId, ueId, session, periode);
        return ResponseEntity.ok(presenter.presentList(notes));
    }
}
