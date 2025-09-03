package com.tanguydev.ismb.Domain.Entity;

import java.util.Set;

public class DomainRole extends AbstractEntity{
    private String name;
    private Set<DomainPermission> domainPermissions;

    public DomainRole(String name, Set<DomainPermission> domainPermissions) {
        this.name = name;
        this.domainPermissions = domainPermissions;
    }

    public String getName() { return name; }
    public Set<DomainPermission> getPermissions() { return domainPermissions; }
}
