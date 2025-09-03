package com.tanguydev.ismb.Infrastructure.Adapter;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import com.tanguydev.ismb.Domain.Ports.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepositoryInterface repository;

    public UserService(UserRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public Optional<DomainUser> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    @Override
    public DomainUser save(DomainUser user) {
        return this.repository.save(user);
    }
}
