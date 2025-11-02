package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

import java.util.Optional;

public interface UpdatePermissionUseCaseInterface {
    Optional<DomainPermission> execute(Long id, DomainPermission permission);
}
