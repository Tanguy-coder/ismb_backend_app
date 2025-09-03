package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.Optional;

public interface UserServiceInterface {
    Optional<DomainUser> findByUsername(String username);
    DomainUser save(DomainUser user);
}
