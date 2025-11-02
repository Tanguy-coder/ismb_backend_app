package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;
import com.tanguydev.ismb.Domain.Presenter.PermissionPresenterInterface;
import com.tanguydev.ismb.Domain.Response.PermissionResponse;
import com.tanguydev.ismb.Domain.UseCases.Permission.*;
import com.tanguydev.ismb.Infrastructure.Mapper.PermissionMapper;
import com.tanguydev.ismb.Infrastructure.Request.PermissionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final CreatePermissionUseCaseInterface createPermissionUseCase;
    private final GetAllPermissionsUseCaseInterface getAllPermissionsUseCase;
    private final GetPermissionByIdUseCaseInterface getPermissionByIdUseCase;
    private final UpdatePermissionUseCaseInterface updatePermissionUseCase;
    private final DeletePermissionUseCaseInterface deletePermissionUseCase;
    private final PermissionPresenterInterface permissionPresenter;
    private final PermissionMapper permissionMapper;

    public PermissionController(CreatePermissionUseCaseInterface createPermissionUseCase, GetAllPermissionsUseCaseInterface getAllPermissionsUseCase, GetPermissionByIdUseCaseInterface getPermissionByIdUseCase, UpdatePermissionUseCaseInterface updatePermissionUseCase, DeletePermissionUseCaseInterface deletePermissionUseCase, PermissionPresenterInterface permissionPresenter, PermissionMapper permissionMapper) {
        this.createPermissionUseCase = createPermissionUseCase;
        this.getAllPermissionsUseCase = getAllPermissionsUseCase;
        this.getPermissionByIdUseCase = getPermissionByIdUseCase;
        this.updatePermissionUseCase = updatePermissionUseCase;
        this.deletePermissionUseCase = deletePermissionUseCase;
        this.permissionPresenter = permissionPresenter;
        this.permissionMapper = permissionMapper;
    }

    @GetMapping
    public ResponseEntity<List<PermissionResponse>> index() {
        List<DomainPermission> permissions = getAllPermissionsUseCase.execute();
        return ResponseEntity.ok(permissionPresenter.presentList(permissions));
    }

    @PostMapping
    public ResponseEntity<PermissionResponse> store( @RequestBody PermissionRequest request) {
        DomainPermission domainPermission = permissionMapper.toDomain(request);
        DomainPermission createdPermission = createPermissionUseCase.execute(domainPermission);
        return new ResponseEntity<>(permissionPresenter.present(createdPermission), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionResponse> show(@PathVariable Long id) {
        return getPermissionByIdUseCase.execute(id)
                .map(domainPermission -> ResponseEntity.ok(permissionPresenter.present(domainPermission)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermissionResponse> update(@PathVariable Long id, @RequestBody PermissionRequest request) {
        DomainPermission domainPermission = permissionMapper.toDomain(request);
        return updatePermissionUseCase.execute(id, domainPermission)
                .map(updatedPermission -> ResponseEntity.ok(permissionPresenter.present(updatedPermission)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deletePermissionUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
