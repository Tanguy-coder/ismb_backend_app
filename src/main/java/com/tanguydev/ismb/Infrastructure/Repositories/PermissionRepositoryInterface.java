package com.tanguydev.ismb.Infrastructure.Repositories;

import com.tanguydev.ismb.Infrastructure.Models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepositoryInterface extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(String name);
}
