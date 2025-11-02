package com.tanguydev.ismb.Domain.UseCases.Users;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUsersUseCase implements ListUsersUseCaseInterface {

    private final UserServiceInterface userService;

    public ListUsersUseCase(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public List<DomainUser> execute() {
        return userService.getAll();
    }
}
