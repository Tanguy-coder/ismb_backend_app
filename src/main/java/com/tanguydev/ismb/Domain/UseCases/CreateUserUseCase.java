package com.tanguydev.ismb.Domain.UseCases;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;

public class CreateUserUseCase implements CreateUserUseCaseInterface{
    private final UserServiceInterface service;

    public CreateUserUseCase(UserServiceInterface service) {
        this.service = service;
    }

    @Override
    public DomainUser execute(DomainUser user) {
        return null;
    }
}
