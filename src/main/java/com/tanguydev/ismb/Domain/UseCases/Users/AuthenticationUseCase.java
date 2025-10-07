package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;

import java.util.Optional;

public class AuthenticationUseCase implements AuthenticationUseCaseInterface{
    private final UserServiceInterface service;

    public AuthenticationUseCase(UserServiceInterface service) {
        this.service = service;
    }

    @Override
    public Optional<DomainUser> execute(String username, String password) {
        return this.service.findByUsername(username)
                .filter(user -> user.getPassword().equals(password));
    }
}
