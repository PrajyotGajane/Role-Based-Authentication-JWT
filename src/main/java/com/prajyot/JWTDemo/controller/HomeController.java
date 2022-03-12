package com.prajyot.JWTDemo.controller;

import com.prajyot.JWTDemo.model.JwtRequest;
import com.prajyot.JWTDemo.model.JwtResponse;
import com.prajyot.JWTDemo.service.UserService;
import com.prajyot.JWTDemo.utility.JWTUtility;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@RestController
public class HomeController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        System.out.println("Here hello");
        return "Welcome to Hell";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) {
        System.out.println("Heree");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(),
                jwtRequest.getPassword())
        );
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

                final String token = jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }

}
