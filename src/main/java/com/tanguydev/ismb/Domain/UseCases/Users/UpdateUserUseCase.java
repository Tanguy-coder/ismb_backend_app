package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase implements UpdateUserUseCaseInterface {

    private final UserServiceInterface userService;

    public UpdateUserUseCase(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public DomainUser execute(Long id, DomainUser user) {
        return userService.update(id, user);
    }
}
