package com.tanguydev.ismb.Infrastructure.Controllers;

import com.tanguydev.ismb.Infrastructure.Request.LoginRequest;
import com.tanguydev.ismb.Infrastructure.Security.CustomUserDetails;
import com.tanguydev.ismb.Infrastructure.Security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tanguydev.ismb.Domain.Response.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwt;

    public AuthController(AuthenticationManager authManager, JwtTokenProvider jwt) {
        this.authManager = authManager; this.jwt = jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
        );
        var userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwt.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
