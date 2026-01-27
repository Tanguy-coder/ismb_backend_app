package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Presenter.ListClassePresenterInterface;
import com.tanguydev.ismb.Domain.Response.ListClasseResponse;
import com.tanguydev.ismb.Domain.UseCases.Parcourt.ListeClasseUseCaseInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parcourt")
public class ParcourtController {
    private final ListeClasseUseCaseInterface  listeClasseUseCase;
    private final ListClassePresenterInterface presenter;

    public ParcourtController(ListeClasseUseCaseInterface listeClasseUseCase, ListClassePresenterInterface presenter) {
        this.listeClasseUseCase = listeClasseUseCase;
        this.presenter = presenter;
    }

    @GetMapping("/liste-classe/{filiereId}/{anneeScolaireId}")
    public ResponseEntity<List<ListClasseResponse>> listeClasse(@PathVariable Long filiereId, @PathVariable Long anneeScolaireId) {
        List<DomainEtudiant> etudiants = listeClasseUseCase.execute(filiereId, anneeScolaireId);
        return ResponseEntity.ok(presenter.present(etudiants));

    }
}
