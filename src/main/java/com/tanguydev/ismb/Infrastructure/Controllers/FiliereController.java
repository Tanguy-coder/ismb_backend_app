package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Presenter.FilierePresenterInterface;
import com.tanguydev.ismb.Domain.Response.FiliereResponse;
import com.tanguydev.ismb.Domain.UseCases.Filiere.*;
import com.tanguydev.ismb.Infrastructure.Mapper.FiliereMapper;
import com.tanguydev.ismb.Infrastructure.Request.FiliereRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {

    private final CreateFiliereUseCaseInterface createFiliereUseCase;
    private final ListFiliereUseCaseInterface listFiliereUseCase;
    private final GetFiliereByIdUseCaseInterface getFiliereByIdUseCase;
    private final UpdateFiliereUseCaseInterface updateFiliereUseCase;
    private final FilierePresenterInterface presenter;
    private final FiliereMapper filiereMapper;

    public FiliereController(CreateFiliereUseCaseInterface createFiliereUseCase, ListFiliereUseCaseInterface listFiliereUseCase, GetFiliereByIdUseCaseInterface getFiliereByIdUseCase, UpdateFiliereUseCaseInterface updateFiliereUseCase, FilierePresenterInterface presenter, FiliereMapper filiereMapper) {
        this.createFiliereUseCase = createFiliereUseCase;
        this.listFiliereUseCase = listFiliereUseCase;
        this.getFiliereByIdUseCase = getFiliereByIdUseCase;
        this.updateFiliereUseCase = updateFiliereUseCase;
        this.presenter = presenter;
        this.filiereMapper = filiereMapper;
    }

    @GetMapping
    public ResponseEntity<List<FiliereResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listFiliereUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FiliereResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getFiliereByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<FiliereResponse> store(@RequestBody FiliereRequest filiereRequest) {
        DomainFiliere newFiliere = filiereMapper.toDomain(filiereRequest);
        DomainFiliere createdFiliere = createFiliereUseCase.execute(newFiliere, filiereRequest.getNiveau().getId());
        return ResponseEntity.ok(presenter.present(createdFiliere));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereResponse> update(@PathVariable Long id, @RequestBody FiliereRequest filiereRequest) {
        DomainFiliere updatedFiliere = filiereMapper.toDomain(filiereRequest);
        DomainFiliere result = updateFiliereUseCase.execute(id, updatedFiliere);
        return ResponseEntity.ok(presenter.present(result));
    }
}