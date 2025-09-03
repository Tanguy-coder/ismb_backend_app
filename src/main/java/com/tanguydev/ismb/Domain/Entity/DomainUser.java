package com.tanguydev.ismb.Domain.Entity;

import java.util.Set;

public class DomainUser extends AbstractEntity{
    private String nom;
    private String prenom;
    private String username;
    private String contact;
    private String password;
    private Set<DomainRole> roles;
    private boolean isActive;

    public DomainUser(String nom, String prenom, String username, String contact, String password, Set<DomainRole> roles, boolean isActive) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.contact = contact;
        this.password = password;
        this.roles = roles;
        this.isActive = isActive;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<DomainRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<DomainRole> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
