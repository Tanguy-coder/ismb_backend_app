package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdUseCase implements FindUserByIdUseCaseInterface {

    private final UserServiceInterface userService;

    public FindUserByIdUseCase(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public DomainUser execute(Long id) {
        return userService.findById(id);
    }
}
