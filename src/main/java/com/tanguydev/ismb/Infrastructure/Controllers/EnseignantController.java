package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainEnseignant;
import com.tanguydev.ismb.Domain.Presenter.EnseignantPresenterInterface;
import com.tanguydev.ismb.Domain.Response.EnseignantResponse;
import com.tanguydev.ismb.Domain.UseCases.Enseignant.*;
import com.tanguydev.ismb.Infrastructure.Mapper.EnseignantMapper;
import com.tanguydev.ismb.Infrastructure.Request.EnseignantRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/enseignants")
public class EnseignantController {

    private final CreateEnseignantUseCase createEnseignantUseCase;
    private final ListEnseignantUseCase listEnseignantUseCase;
    private final GetEnseignantByIdUseCase getEnseignantByIdUseCase;
    private final UpdateEnseignantUseCase updateEnseignantUseCase;
    private final DeleteEnseignantUseCase deleteEnseignantUseCase;
    private final EnseignantPresenterInterface presenter;
    private final EnseignantMapper enseignantMapper;

    public EnseignantController(CreateEnseignantUseCase createEnseignantUseCase, ListEnseignantUseCase listEnseignantUseCase, GetEnseignantByIdUseCase getEnseignantByIdUseCase, UpdateEnseignantUseCase updateEnseignantUseCase, DeleteEnseignantUseCase deleteEnseignantUseCase, EnseignantPresenterInterface presenter, EnseignantMapper enseignantMapper) {
        this.createEnseignantUseCase = createEnseignantUseCase;
        this.listEnseignantUseCase = listEnseignantUseCase;
        this.getEnseignantByIdUseCase = getEnseignantByIdUseCase;
        this.updateEnseignantUseCase = updateEnseignantUseCase;
        this.deleteEnseignantUseCase = deleteEnseignantUseCase;
        this.presenter = presenter;
        this.enseignantMapper = enseignantMapper;
    }

    @GetMapping
    public ResponseEntity<List<EnseignantResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listEnseignantUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnseignantResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getEnseignantByIdUseCase.execute(id)));
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EnseignantResponse> store(@RequestPart("enseignant") EnseignantRequest enseignantRequest, @RequestPart(value = "photo", required = false) MultipartFile photoFile) {
        DomainEnseignant newEnseignant = enseignantMapper.toDomain(enseignantRequest);
        DomainEnseignant createdEnseignant = createEnseignantUseCase.execute(newEnseignant, photoFile);
        return ResponseEntity.ok(presenter.present(createdEnseignant));
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EnseignantResponse> update(@PathVariable Long id, @RequestPart("enseignant") EnseignantRequest enseignantRequest, @RequestPart(value = "photo", required = false) MultipartFile photoFile) {
        DomainEnseignant updatedEnseignant = enseignantMapper.toDomain(enseignantRequest);
        DomainEnseignant result = updateEnseignantUseCase.execute(id, updatedEnseignant, photoFile);
        return ResponseEntity.ok(presenter.present(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteEnseignantUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
