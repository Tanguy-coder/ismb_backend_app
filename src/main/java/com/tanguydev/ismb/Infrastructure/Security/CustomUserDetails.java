package com.tanguydev.ismb.Infrastructure.Security;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private final DomainUser user;

    public CustomUserDetails(DomainUser user) {
        this.user = user;
    }

    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getRoles().stream()
//                .flatMap(role -> role.getPermissions().stream())
//                .map(permission -> (GrantedAuthority) permission::getName)
//                .collect(Collectors.toSet());
//    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = new HashSet<GrantedAuthority>();
        System.out.println(authorities);
        if (user.getRoles() == null) return authorities;

        user.getRoles().forEach(role -> {
            // ajouter le role en tant qu'autorité (préfixe ROLE_)
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));

            if (role.getPermissions() != null) {
                role.getPermissions()
                        .stream()
                        .map(p -> new SimpleGrantedAuthority(p.getName()))
                        .forEach(authorities::add);
            }
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
