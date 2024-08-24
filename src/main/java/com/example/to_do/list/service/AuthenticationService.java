package com.example.to_do.list.service;

import com.example.to_do.list.DTO.LoginUserDto;
import com.example.to_do.list.DTO.RegisterUserDto;
import com.example.to_do.list.entity.UserEntity;
import com.example.to_do.list.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity signup(RegisterUserDto input) {
        UserEntity user = new UserEntity();
        user.setUserEmail(input.getUserEmail());
        user.setUserName(input.getUserName());
        user.setUserPassword(passwordEncoder.encode(input.getUserPassword()));

        return userRepository.save(user);
    }

    public UserEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUserEmail(),
                        input.getUserPassword()
                )
        );

        return userRepository.findByuserEmail(input.getUserEmail())
                .orElseThrow();
    }
}