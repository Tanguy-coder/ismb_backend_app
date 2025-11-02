package com.tanguydev.ismb.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomainUser extends AbstractEntity{
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String contact;
    private String password;
    private Set<DomainRole> roles = new java.util.HashSet<>();
    private boolean isActive = true;
}
