package com.workshop.BOALI.controllers;

import com.workshop.BOALI.config.JwtService;
import com.workshop.BOALI.user.Role;
import com.workshop.BOALI.user.User;
import com.workshop.BOALI.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo repo;
    private final BCryptPasswordEncoder passwordEncoder ;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthRes register(RegisterReq req) {
        var user = User.builder()
                .firstName(req.getFirstName())
                .lastName(req.getLastName())
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(Role.USER)
                .build();
        repo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthRes.builder()
                .token(jwtToken)
                .build();
    }

    public AuthRes auth(authReq req) {
        System.out.println(passwordEncoder.encode(req.getPassword()));
        System.out.println(req.getPassword());
     UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(req.getEmail(),req.getPassword());
      authenticationManager.authenticate(authenticationToken);
      var user = repo.findByEmail(req.getEmail()).orElseThrow();
      System.out.println(user.getPassword() + " email "+user.getEmail() );
      var jwtToken  = jwtService.generateToken(user);
      return AuthRes.builder().token(jwtToken).build();
    }
}

