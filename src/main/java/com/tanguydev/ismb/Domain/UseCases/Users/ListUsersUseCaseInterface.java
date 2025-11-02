package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.List;

public interface ListUsersUseCaseInterface {
    List<DomainUser> execute();
}
