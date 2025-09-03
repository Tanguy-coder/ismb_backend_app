package com.tanguydev.ismb.Domain.Gateway;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.Optional;

public interface UserRepositoryInterface {
    Optional<DomainUser> findByUsername(String username);
    DomainUser save(DomainUser user);
}
