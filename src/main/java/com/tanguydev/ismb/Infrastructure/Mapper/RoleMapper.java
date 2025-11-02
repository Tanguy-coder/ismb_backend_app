package com.tanguydev.ismb.Infrastructure.Mapper;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import com.tanguydev.ismb.Domain.Response.RoleResponse;
import com.tanguydev.ismb.Infrastructure.Models.ERole;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toModel(DomainRole domainRole);
    DomainRole toDomain(Role role);
    RoleResponse toResponse(DomainRole domainRole);
    List<RoleResponse> toResponseList(List<DomainRole> domainRoles);

    // Custom mapping method for String to DomainRole
    default DomainRole map(String roleName) {
        if (roleName == null) {
            return null;
        }
        // Perform case-insensitive matching against enum names to support inputs like "Admin", "admin", etc.
        for (ERole e : ERole.values()) {
            if (e.name().equalsIgnoreCase(roleName)) {
                return new DomainRole(e, null); // Permissions are ignored for this mapping
            }
        }
        // Invalid role name -> return null (could be turned into an exception if desired)
        return null;
    }

    // Custom mapping method for Set<String> to Set<DomainRole>
    default Set<DomainRole> map(Set<String> roleNames) {
        if (roleNames == null) {
            return null;
        }
        return roleNames.stream()
                .map(this::map) // Use the single String to DomainRole mapping
                .filter(java.util.Objects::nonNull) // Filter out nulls if map(String) returns null for invalid roles
                .collect(Collectors.toSet());
    }
}