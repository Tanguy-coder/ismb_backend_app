package com.tanguydev.ismb.Domain.UseCases.Role;

import com.tanguydev.ismb.Domain.Entity.DomainRole;

import java.util.List;

public interface GetAllRolesUseCaseInterface {
    List<DomainRole> execute();
}
