package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

public interface CreatePermissionUseCaseInterface {
    DomainPermission execute(DomainPermission permission);
}
