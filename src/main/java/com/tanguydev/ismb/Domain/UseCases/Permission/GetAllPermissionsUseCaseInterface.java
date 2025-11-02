package com.tanguydev.ismb.Domain.UseCases.Permission;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

import java.util.List;

public interface GetAllPermissionsUseCaseInterface {
    List<DomainPermission> execute();
}
