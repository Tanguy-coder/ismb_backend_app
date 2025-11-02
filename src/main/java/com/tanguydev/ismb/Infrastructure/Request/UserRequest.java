package com.tanguydev.ismb.Infrastructure.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String contact;
    private Set<RoleRequest> roles;
}
