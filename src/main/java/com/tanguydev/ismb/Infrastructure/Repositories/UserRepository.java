package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Mapper.UserMapper;
import com.tanguydev.ismb.Infrastructure.Models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private final UserRepositoryJpaInterface repository;
    private final UserMapper mapper;

    public UserRepository(UserRepositoryJpaInterface repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<DomainUser> findByUsername(String username) {
        return this.repository.findByUsername(username).map(mapper::toDomain);
    }

    @Override
    public DomainUser save(DomainUser user) {
        User jpaUser = this.repository.save(mapper.toJpa(user));
        return mapper.toDomain(jpaUser);
    }
}
