package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainMatiere;
import com.tanguydev.ismb.Domain.Presenter.MatierePresenterInterface;
import com.tanguydev.ismb.Domain.Response.MatiereResponse;
import com.tanguydev.ismb.Domain.UseCases.Matiere.*;
import com.tanguydev.ismb.Infrastructure.Mapper.MatiereMapper;
import com.tanguydev.ismb.Infrastructure.Request.MatiereRequest;
import com.tanguydev.ismb.Infrastructure.Request.NiveauRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;

@RestController
@RequestMapping("/api/matieres")
public class MatiereController {

    private final CreateMatiereUseCaseInterface createMatiereUseCase;
    private final ListMatiereUseCaseInterface listMatiereUseCase;
    private final GetMatiereByIdUseCaseInterface getMatiereByIdUseCase;
    private final UpdateMatiereUseCaseInterface updateMatiereUseCase;
    private final DeleteMatiereUseCaseInterface deleteMatiereUseCase;
    private final MatierePresenterInterface presenter;
    private final MatiereMapper matiereMapper;

    public MatiereController(CreateMatiereUseCaseInterface createMatiereUseCase, ListMatiereUseCaseInterface listMatiereUseCase, GetMatiereByIdUseCaseInterface getMatiereByIdUseCase, UpdateMatiereUseCaseInterface updateMatiereUseCase, DeleteMatiereUseCaseInterface deleteMatiereUseCase, MatierePresenterInterface presenter, MatiereMapper matiereMapper) {
        this.createMatiereUseCase = createMatiereUseCase;
        this.listMatiereUseCase = listMatiereUseCase;
        this.getMatiereByIdUseCase = getMatiereByIdUseCase;
        this.updateMatiereUseCase = updateMatiereUseCase;
        this.deleteMatiereUseCase = deleteMatiereUseCase;
        this.presenter = presenter;
        this.matiereMapper = matiereMapper;
    }

    @GetMapping
    public ResponseEntity<List<MatiereResponse>> index() {
        return ResponseEntity.ok(presenter.presentList(listMatiereUseCase.execute()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatiereResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(presenter.present(getMatiereByIdUseCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<MatiereResponse> store(@RequestBody MatiereRequest matiereRequest) {
        DomainMatiere newMatiere = matiereMapper.toDomain(matiereRequest);

        Set<Long> niveauIds = new HashSet<>();

        if (matiereRequest.getNiveauRequests() != null) {
            niveauIds.addAll(matiereRequest.getNiveauRequests().stream()
                    .map(NiveauRequest::getId)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()));
        }

        if (matiereRequest.getNiveauIds() != null) {
            niveauIds.addAll(matiereRequest.getNiveauIds().stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()));
        }

        DomainMatiere createdMatiere = createMatiereUseCase.execute(newMatiere, niveauIds);
        return ResponseEntity.ok(presenter.present(createdMatiere));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatiereResponse> update(@PathVariable Long id, @RequestBody MatiereRequest matiereRequest) {
        DomainMatiere updatedMatiere = matiereMapper.toDomain(matiereRequest);

        Set<Long> niveauIds = new HashSet<>();

        if (matiereRequest.getNiveauRequests() != null) {
            niveauIds.addAll(matiereRequest.getNiveauRequests().stream()
                    .map(NiveauRequest::getId)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()));
        }

        if (matiereRequest.getNiveauIds() != null) {
            niveauIds.addAll(matiereRequest.getNiveauIds().stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet()));
        }

        DomainMatiere result = updateMatiereUseCase.execute(id, updatedMatiere, niveauIds);
        return ResponseEntity.ok(presenter.present(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteMatiereUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
