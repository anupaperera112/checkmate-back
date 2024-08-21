package com.example.to_do.list.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private int userId ;
    private String userName;
    private String userEmail;
    private String userPassword;
}
