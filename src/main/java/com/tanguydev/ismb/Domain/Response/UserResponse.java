package com.tanguydev.ismb.Domain.Response;

import com.tanguydev.ismb.Domain.Entity.DomainRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String nom;
    private String prenom;
    private String username;
    private String email;
    private String contact;
    private Set<String> roles;
    private boolean isActive;
}