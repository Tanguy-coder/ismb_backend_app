package com.tanguydev.ismb.Infrastructure.Security;

import com.tanguydev.ismb.Domain.Entity.DomainUser;
import com.tanguydev.ismb.Domain.Gateway.UserRepositoryInterface;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final  UserRepositoryInterface repository;

    public CustomUserDetailsService(UserRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DomainUser user = this.repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return new CustomUserDetails(user);
    }
}
