package com.bank.controller;


import com.bank.model.User;
import com.bank.service.ClientServiceImpl;
import com.bank.service.UserServiceImpl;
import com.bank.service.helpers.AuthenticationRequest;
import com.bank.service.helpers.JwtHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;
    private final JwtHandler jwtHandler;


    @PostMapping("/auth/{role}")
    public ResponseEntity<String> authenticate(
            @PathVariable String role,
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getEmail() + ":" + role,
                            authenticationRequest.getPassword())
            );

            final User user = userService.loadUserByUsername(authenticationRequest.getEmail() + ":" + role);
            if(user != null){
                return ResponseEntity.ok(jwtHandler.generateToken(user));
            }

        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(400).body("Error authenticating user");
    }
}
