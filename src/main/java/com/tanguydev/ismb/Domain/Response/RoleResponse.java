package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.DomainPermission;

import java.util.Set;

public class RoleResponse {
    private String name;
    private Set<DomainPermission> permissions;

    public RoleResponse(String name, Set<DomainPermission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DomainPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<DomainPermission> permissions) {
        this.permissions = permissions;
    }
}