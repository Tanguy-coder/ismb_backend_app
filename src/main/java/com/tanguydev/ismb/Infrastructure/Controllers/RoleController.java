package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Presenter.RolePresenterInterface;
import com.tanguydev.ismb.Domain.Response.RoleResponse;
import com.tanguydev.ismb.Domain.UseCases.Role.*;
import com.tanguydev.ismb.Infrastructure.Request.RolePermissionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final GetAllRolesUseCaseInterface getAllRolesUseCase;
    private final GetRoleByIdUseCaseInterface getRoleByIdUseCase;
    private final AddPermissionToRoleUseCaseInterface addPermissionToRoleUseCase;
    private final RemovePermissionFromRoleUseCaseInterface removePermissionFromRoleUseCase;
    private final RolePresenterInterface rolePresenter;

    public RoleController(GetAllRolesUseCaseInterface getAllRolesUseCase, GetRoleByIdUseCaseInterface getRoleByIdUseCase, AddPermissionToRoleUseCaseInterface addPermissionToRoleUseCase, RemovePermissionFromRoleUseCaseInterface removePermissionFromRoleUseCase, RolePresenterInterface rolePresenter) {
        this.getAllRolesUseCase = getAllRolesUseCase;
        this.getRoleByIdUseCase = getRoleByIdUseCase;
        this.addPermissionToRoleUseCase = addPermissionToRoleUseCase;
        this.removePermissionFromRoleUseCase = removePermissionFromRoleUseCase;
        this.rolePresenter = rolePresenter;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> index() {
        List<DomainRole> roles = getAllRolesUseCase.execute();
        return ResponseEntity.ok(rolePresenter.presentList(roles));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> show(@PathVariable Long id) {
        return getRoleByIdUseCase.execute(id)
                .map(domainRole -> ResponseEntity.ok(rolePresenter.present(domainRole)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{roleId}/permissions")
    public ResponseEntity<RoleResponse> addPermission(@PathVariable Long roleId, @RequestBody RolePermissionRequest request) {
        return addPermissionToRoleUseCase.execute(roleId, request.getPermissionId())
                .map(updatedRole -> ResponseEntity.ok(rolePresenter.present(updatedRole)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    public ResponseEntity<RoleResponse> removePermission(@PathVariable Long roleId, @PathVariable Long permissionId) {
        return removePermissionFromRoleUseCase.execute(roleId, permissionId)
                .map(updatedRole -> ResponseEntity.ok(rolePresenter.present(updatedRole)))
                .orElse(ResponseEntity.notFound().build());
    }
}
