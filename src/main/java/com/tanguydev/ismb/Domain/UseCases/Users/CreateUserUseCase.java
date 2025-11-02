package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements CreateUserUseCaseInterface {

    private final UserServiceInterface userService;

    public CreateUserUseCase(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public DomainUser execute(DomainUser user) {
        return userService.save(user);
    }
}