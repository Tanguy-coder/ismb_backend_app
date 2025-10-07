package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainAnneeScolaire;
import com.tanguydev.ismb.Domain.Presenter.AnneeScolairePrsenterInterface;
import com.tanguydev.ismb.Domain.Response.AnneeScolaireResponse;
import com.tanguydev.ismb.Domain.UseCases.annee.CreateAnneeUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.annee.GetAnneeByIdUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.annee.ListAnneeUseCaseInterface;
import com.tanguydev.ismb.Domain.UseCases.annee.UpdateAnneeUseCaseInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annees")
public class AnneeScolaireController {
    private final CreateAnneeUseCaseInterface store;
    private final ListAnneeUseCaseInterface list;
    private final GetAnneeByIdUseCaseInterface show;
    private final UpdateAnneeUseCaseInterface update;
    private final AnneeScolairePrsenterInterface presenter;

    public AnneeScolaireController(CreateAnneeUseCaseInterface store, ListAnneeUseCaseInterface list, GetAnneeByIdUseCaseInterface show, UpdateAnneeUseCaseInterface update, AnneeScolairePrsenterInterface presenter) {
        this.store = store;
        this.list = list;
        this.show = show;
        this.update = update;
        this.presenter = presenter;
    }

    @GetMapping
    public ResponseEntity<List<AnneeScolaireResponse>> index()
    {
        return ResponseEntity.ok(presenter.presentList(list.execute()));
    }

    @PostMapping
    public ResponseEntity<AnneeScolaireResponse> store(@RequestBody DomainAnneeScolaire domainAnneeScolaire)
    {
        return ResponseEntity.ok(presenter.present(store.execute(domainAnneeScolaire)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnneeScolaireResponse> show(@PathVariable Long id)
    {
        return ResponseEntity.ok(presenter.present(show.execute(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnneeScolaireResponse> update(@PathVariable Long id, @RequestBody DomainAnneeScolaire anneeScolaire)
    {
        return ResponseEntity.ok(presenter.present(update.execute(id, anneeScolaire)));
    }
}
