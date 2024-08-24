package com.example.to_do.list.DTO;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    private String userEmail;

    private String userPassword;

    // getters and setters here...
}
