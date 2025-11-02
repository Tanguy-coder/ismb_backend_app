package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryInterface {
    Optional<DomainUser> findByUsername(String username);
    Optional<DomainUser> findByUsernameOrEmail(String username, String email);

    DomainUser save(DomainUser user);
    DomainUser findById(Long id);
    DomainUser update(Long id, DomainUser user);
    List<DomainUser> getAll();
}