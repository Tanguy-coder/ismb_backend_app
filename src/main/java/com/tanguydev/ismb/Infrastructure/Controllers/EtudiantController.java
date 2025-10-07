package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Entity.DomainNiveau;
import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Presenter.EtudiantPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;
import com.tanguydev.ismb.Domain.UseCases.Etudiant.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final CreateEtudiantUseCaseInterface createEtudiantUseCase;
    private final ListEtudiantUseCaseInterface listEtudiantUseCase;
    private final GetEtudiantByIdUseCaseInterface getEtudiantByIdUseCase;
    private final UpdateEtudiantUseCaseInterface updateEtudiantUseCase;
    private final EtudiantPresenterInterface presenter;

    public EtudiantController(CreateEtudiantUseCaseInterface createEtudiantUseCase, ListEtudiantUseCaseInterface listEtudiantUseCase, GetEtudiantByIdUseCaseInterface getEtudiantByIdUseCase, UpdateEtudiantUseCaseInterface updateEtudiantUseCase, EtudiantPresenterInterface presenter) {
        this.createEtudiantUseCase = createEtudiantUseCase;
        this.listEtudiantUseCase = listEtudiantUseCase;
        this.getEtudiantByIdUseCase = getEtudiantByIdUseCase;
        this.updateEtudiantUseCase = updateEtudiantUseCase;
        this.presenter = presenter;
    }

    @GetMapping
    public ResponseEntity<List<EtudiantResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listEtudiantUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getEtudiantByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<EtudiantResponse> store(
            @RequestParam("userId") Long userId,
            @RequestParam("sexe") String sexe,
            @RequestParam("dateNaissance") LocalDate dateNaissance,
            @RequestParam("telephone") String telephone,
            @RequestParam("nationalite") String nationalite,
            @RequestParam(value = "photo", required = false) MultipartFile photoFile,
            @RequestParam("niveauId") Long niveauId,
            @RequestParam("attentes") String attentes) {

        DomainUser user = new DomainUser();
        user.setId(userId);

        DomainNiveau niveau = new DomainNiveau();
        niveau.setId(niveauId);

        DomainEtudiant newEtudiant = new DomainEtudiant();
        newEtudiant.setUser(user);
        newEtudiant.setSexe(sexe);
        newEtudiant.setDateNaissance(dateNaissance);
        newEtudiant.setTelephone(telephone);
        newEtudiant.setNationalite(nationalite);
        newEtudiant.setNiveau(niveau);
        newEtudiant.setAttentes(attentes);

        DomainEtudiant createdEtudiant = createEtudiantUseCase.execute(newEtudiant, photoFile);

        return ResponseEntity.ok(presenter.present(createdEtudiant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtudiantResponse> update(
            @PathVariable Long id,
            @RequestParam("userId") Long userId,
            @RequestParam("sexe") String sexe,
            @RequestParam("dateNaissance") LocalDate dateNaissance,
            @RequestParam("telephone") String telephone,
            @RequestParam("nationalite") String nationalite,
            @RequestParam(value = "photo", required = false) MultipartFile photoFile,
            @RequestParam("niveauId") Long niveauId,
            @RequestParam("attentes") String attentes) {

        DomainUser user = new DomainUser();
        user.setId(userId);

        DomainNiveau niveau = new DomainNiveau();
        niveau.setId(niveauId);

        DomainEtudiant updatedEtudiant = new DomainEtudiant();
        updatedEtudiant.setUser(user);
        updatedEtudiant.setSexe(sexe);
        updatedEtudiant.setDateNaissance(dateNaissance);
        updatedEtudiant.setTelephone(telephone);
        updatedEtudiant.setNationalite(nationalite);
        updatedEtudiant.setNiveau(niveau);
        updatedEtudiant.setAttentes(attentes);

        DomainEtudiant result = updateEtudiantUseCase.execute(id, updatedEtudiant, photoFile);

        return ResponseEntity.ok(presenter.present(result));
    }
}
