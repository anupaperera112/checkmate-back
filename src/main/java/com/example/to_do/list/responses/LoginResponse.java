package com.example.to_do.list.responses;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoginResponse {
    private String token;

    private long expiresIn;

    // Getters and setters...
}
