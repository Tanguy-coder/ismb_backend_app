package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.Optional;

public interface AuthenticationUseCaseInterface {
    Optional<DomainUser> execute(String username, String password);
}
