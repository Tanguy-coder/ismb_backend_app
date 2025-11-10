package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainUe;
import com.tanguydev.ismb.Domain.Presenter.UePresenterInterface;
import com.tanguydev.ismb.Domain.Response.UeResponse;
import com.tanguydev.ismb.Domain.UseCases.Ue.*;
import com.tanguydev.ismb.Infrastructure.Mapper.UeMapper;
import com.tanguydev.ismb.Infrastructure.Request.UeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ues")
public class UeController {

    private final CreateUeUseCase createUeUseCase;
    private final ListUeUseCase listUeUseCase;
    private final GetUeByIdUseCase getUeByIdUseCase;
    private final UpdateUeUseCase updateUeUseCase;
    private final DeleteUeUseCase deleteUeUseCase;
    private final UePresenterInterface presenter;
    private final UeMapper ueMapper;

    public UeController(CreateUeUseCase createUeUseCase, ListUeUseCase listUeUseCase, GetUeByIdUseCase getUeByIdUseCase, UpdateUeUseCase updateUeUseCase, DeleteUeUseCase deleteUeUseCase, UePresenterInterface presenter, UeMapper ueMapper) {
        this.createUeUseCase = createUeUseCase;
        this.listUeUseCase = listUeUseCase;
        this.getUeByIdUseCase = getUeByIdUseCase;
        this.updateUeUseCase = updateUeUseCase;
        this.deleteUeUseCase = deleteUeUseCase;
        this.presenter = presenter;
        this.ueMapper = ueMapper;
    }

    @GetMapping
    public ResponseEntity<List<UeResponse>> index() {
        System.out.println();
        return ResponseEntity.ok(presenter.presentList(listUeUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UeResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getUeByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<UeResponse> store(@RequestBody UeRequest ueRequest) {
        DomainUe newUe = ueMapper.toDomain(ueRequest);
        DomainUe createdUe = createUeUseCase.execute(newUe, ueRequest.getMatiere().getId(), ueRequest.getEnseignant().getId(), ueRequest.getAnneeScolaire().getId(), ueRequest.getFiliere().getId());
        return ResponseEntity.ok(presenter.present(createdUe));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UeResponse> update(@PathVariable Long id, @RequestBody UeRequest ueRequest) {
        DomainUe updatedUe = ueMapper.toDomain(ueRequest);
        DomainUe result = updateUeUseCase.execute(id, updatedUe, ueRequest.getMatiere().getId(), ueRequest.getEnseignant().getId(), ueRequest.getAnneeScolaire().getId(), ueRequest.getFiliere().getId());
        return ResponseEntity.ok(presenter.present(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteUeUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
