package com.tanguydev.ismb.Domain.Ports;

import com.tanguydev.ismb.Domain.Entity.DomainUser;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    Optional<DomainUser> findByUsername(String username);
    DomainUser save(DomainUser user);
    DomainUser findById(Long id);
    DomainUser update(Long id, DomainUser user);
    List<DomainUser> getAll();
}