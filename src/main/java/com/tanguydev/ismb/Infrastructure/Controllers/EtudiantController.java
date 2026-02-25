package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainEtudiant;
import com.tanguydev.ismb.Domain.Presenter.EtudiantPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EtudiantResponse;
import com.tanguydev.ismb.Domain.UseCases.Etudiant.*;
import com.tanguydev.ismb.Infrastructure.Mapper.EtudiantMapper;
import com.tanguydev.ismb.Infrastructure.Request.EtudiantRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final CreateEtudiantUseCaseInterface createEtudiantUseCase;
    private final ListEtudiantUseCaseInterface listEtudiantUseCase;
    private final GetEtudiantByIdUseCaseInterface getEtudiantByIdUseCase;
    private final UpdateEtudiantUseCaseInterface updateEtudiantUseCase;
    private final DeleteEtudiantUseCaseInterface deleteEtudiantUseCase;
    private final EtudiantPresenterInterface presenter;
    private final EtudiantMapper etudiantMapper;

    public EtudiantController(CreateEtudiantUseCaseInterface createEtudiantUseCase, ListEtudiantUseCaseInterface listEtudiantUseCase, GetEtudiantByIdUseCaseInterface getEtudiantByIdUseCase, UpdateEtudiantUseCaseInterface updateEtudiantUseCase, DeleteEtudiantUseCaseInterface deleteEtudiantUseCase, EtudiantPresenterInterface presenter, EtudiantMapper etudiantMapper) {
        this.createEtudiantUseCase = createEtudiantUseCase;
        this.listEtudiantUseCase = listEtudiantUseCase;
        this.getEtudiantByIdUseCase = getEtudiantByIdUseCase;
        this.updateEtudiantUseCase = updateEtudiantUseCase;
        this.deleteEtudiantUseCase = deleteEtudiantUseCase;
        this.presenter = presenter;
        this.etudiantMapper = etudiantMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtudiantResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listEtudiantUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getEtudiantByIdUseCase.execute(id)));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EtudiantResponse> store(
            @RequestPart("etudiant") EtudiantRequest etudiantRequest,
            @RequestPart(value = "photo", required = false) MultipartFile photoFile) {
        DomainEtudiant newEtudiant = etudiantMapper.toDomain(etudiantRequest);
        System.out.println("La request que j'ai:" +etudiantRequest.getFiliere().getId());
        DomainEtudiant createdEtudiant = createEtudiantUseCase.execute(newEtudiant, photoFile, etudiantRequest.getFiliere().getId(), etudiantRequest.getStatut());

        return ResponseEntity.ok(presenter.present(createdEtudiant));
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EtudiantResponse> update(
            @PathVariable Long id,
            @RequestPart("etudiant") EtudiantRequest etudiantRequest,
            @RequestPart(value = "photo", required = false) MultipartFile photoFile) {

        DomainEtudiant updatedEtudiant = etudiantMapper.toDomain(etudiantRequest);

        DomainEtudiant result = updateEtudiantUseCase.execute(id, updatedEtudiant, photoFile);

        return ResponseEntity.ok(presenter.present(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteEtudiantUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
