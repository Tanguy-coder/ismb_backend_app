package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.DomainRole;

import java.util.Set;

public class UserResponse {
    private String nom;
    private String prenom;
    private String username;
    private String contact;
    private Set<DomainRole> roles;
    private boolean active;

    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getUsername() { return username; }
    public String getContact() { return contact; }
    public Set<DomainRole> getRoles() { return roles; }
    public boolean isActive() { return active; }
}