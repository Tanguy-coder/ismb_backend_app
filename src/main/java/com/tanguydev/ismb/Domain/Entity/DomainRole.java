package com.tanguydev.ismb.Domain.Entity;

import com.tanguydev.ismb.Infrastructure.Models.ERole;

import java.util.Objects;
import java.util.Set;

public class DomainRole extends AbstractEntity {
    private ERole name;
    private Set<DomainPermission> domainPermissions;

    public DomainRole() {
    }

    public DomainRole(ERole name, Set<DomainPermission> domainPermissions) {
        this.name = name;
        this.domainPermissions = domainPermissions;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public Set<DomainPermission> getPermissions() {
        return domainPermissions;
    }

    public void setPermissions(Set<DomainPermission> permissions) {
        this.domainPermissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainRole that = (DomainRole) o;
        return name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}