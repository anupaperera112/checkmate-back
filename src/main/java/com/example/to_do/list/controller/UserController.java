package com.example.to_do.list.controller;

import com.example.to_do.list.DTO.UserDTO;
import com.example.to_do.list.service.UserService;

import com.example.to_do.list.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO.getUserEmail());
        int userId = userService.addUser(userDTO);
        System.out.println(userDTO.getUserId());
        if (userId >0){
            return new ResponseEntity<>(
            new StandardResponse(200,"Sign up succesfull",userId),
            HttpStatus.CREATED
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(404,"unsuccessful sign up",null),
                    HttpStatus.NOT_FOUND
            );
        }
    }


}
