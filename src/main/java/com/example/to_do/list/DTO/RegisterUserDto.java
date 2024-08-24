package com.example.to_do.list.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterUserDto {
    private String userEmail;

    private String userPassword;

    private String userName;

    // getters and setters here...
}
