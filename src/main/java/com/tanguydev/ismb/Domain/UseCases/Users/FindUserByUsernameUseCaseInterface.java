package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.Optional;

public interface FindUserByUsernameUseCaseInterface {
    Optional<DomainUser> execute(String username);
}
