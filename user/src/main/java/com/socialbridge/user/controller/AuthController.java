package com.socialbridge.user.controller;

import com.socialbridge.user.model.User;
import com.socialbridge.user.security.JwtUtils;
import com.socialbridge.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<Object> login() {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        "v.siverskiy@gmail.com",
                        "Password_1"
                        ));
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(user.getUsername());
        return ResponseEntity.ok(jwtToken);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup() {
        User user = userService.create(User.builder()
                        .email("v.siverskiy@gmail.com")
                        .firstName("Vladyslav")
                        .lastName("Siverskiy")
                        .password("Password_1")
                .build());
        var jwtToken = jwtUtils.generateToken(user.getEmail());
        return ResponseEntity.ok(jwtToken);
    }
}