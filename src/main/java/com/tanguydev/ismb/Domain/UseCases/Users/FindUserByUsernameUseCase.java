package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByUsernameUseCase implements FindUserByUsernameUseCaseInterface {

    private final UserServiceInterface userService;

    public FindUserByUsernameUseCase(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public Optional<DomainUser> execute(String username) {
        return userService.findByUsername(username);
    }
}
