package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Presenter.NiveauPresenterInterface;
import com.tanguydev.ismb.Domain.Response.NiveauResponse;
import com.tanguydev.ismb.Domain.UseCases.Niveau.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/niveaus")
public class NiveauController {

    private final CreateNiveauUseCaseInterface createNiveauUseCase;
    private final ListNiveauUseCaseInterface listNiveauUseCase;
    private final GetNiveauByIdUseCaseInterface getNiveauByIdUseCase;
    private final UpdateNiuveauUseCaseInterface updateNiveauUseCase;
    private final NiveauPresenterInterface presenter;

    public NiveauController(CreateNiveauUseCaseInterface createNiveauUseCase, ListNiveauUseCaseInterface listNiveauUseCase, GetNiveauByIdUseCaseInterface getNiveauByIdUseCase, UpdateNiuveauUseCaseInterface updateNiveauUseCase, NiveauPresenterInterface presenter) {
        this.createNiveauUseCase = createNiveauUseCase;
        this.listNiveauUseCase = listNiveauUseCase;
        this.getNiveauByIdUseCase = getNiveauByIdUseCase;
        this.updateNiveauUseCase = updateNiveauUseCase;
        this.presenter = presenter;
    }

    @GetMapping
    public ResponseEntity<List<NiveauResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listNiveauUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NiveauResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getNiveauByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<NiveauResponse> store(@RequestBody DomainNiveau domainNiveau) {
        DomainNiveau createdNiveau = createNiveauUseCase.execute(domainNiveau);
        return ResponseEntity.ok(presenter.present(createdNiveau));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NiveauResponse> update(@PathVariable Long id, @RequestBody DomainNiveau domainNiveau) {
        DomainNiveau result = updateNiveauUseCase.execute(id, domainNiveau);
        return ResponseEntity.ok(presenter.present(result));
    }
}