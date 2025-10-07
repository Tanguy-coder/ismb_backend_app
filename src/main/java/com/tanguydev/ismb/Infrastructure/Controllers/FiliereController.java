package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainFiliere;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Presenter.FilierePresenterInterface;
import com.tanguydev.ismb.Domain.Response.FiliereResponse;
import com.tanguydev.ismb.Domain.UseCases.Filiere.*;
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

    public FiliereController(CreateFiliereUseCaseInterface createFiliereUseCase, ListFiliereUseCaseInterface listFiliereUseCase, GetFiliereByIdUseCaseInterface getFiliereByIdUseCase, UpdateFiliereUseCaseInterface updateFiliereUseCase, FilierePresenterInterface presenter) {
        this.createFiliereUseCase = createFiliereUseCase;
        this.listFiliereUseCase = listFiliereUseCase;
        this.getFiliereByIdUseCase = getFiliereByIdUseCase;
        this.updateFiliereUseCase = updateFiliereUseCase;
        this.presenter = presenter;
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
        DomainNiveau niveau = new DomainNiveau();
        niveau.setId(filiereRequest.getNiveauId());

        DomainFiliere newFiliere = new DomainFiliere();
        newFiliere.setLibelle(filiereRequest.getLibelle());
        newFiliere.setDescription(filiereRequest.getDescription());
        newFiliere.setNiveau(niveau);

        DomainFiliere createdFiliere = createFiliereUseCase.execute(newFiliere);
        return ResponseEntity.ok(presenter.present(createdFiliere));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FiliereResponse> update(@PathVariable Long id, @RequestBody FiliereRequest filiereRequest) {
        DomainNiveau niveau = new DomainNiveau();
        niveau.setId(filiereRequest.getNiveauId());

        DomainFiliere updatedFiliere = new DomainFiliere();
        updatedFiliere.setLibelle(filiereRequest.getLibelle());
        updatedFiliere.setDescription(filiereRequest.getDescription());
        updatedFiliere.setNiveau(niveau);

        DomainFiliere result = updateFiliereUseCase.execute(id, updatedFiliere);
        return ResponseEntity.ok(presenter.present(result));
    }
}