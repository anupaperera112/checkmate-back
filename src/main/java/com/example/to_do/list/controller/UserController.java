package com.example.to_do.list.controller;
import com.example.to_do.list.responses.LoginResponse;
import com.example.to_do.list.DTO.LoginUserDto;
import com.example.to_do.list.DTO.RegisterUserDto;
import com.example.to_do.list.entity.UserEntity;
import com.example.to_do.list.service.AuthenticationService;
import com.example.to_do.list.service.JwtService;
import com.example.to_do.list.utils.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")

public class UserController {


    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public UserController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<StandardResponse> registerUser(@RequestBody RegisterUserDto registerUserDto){
        System.out.println(registerUserDto.getUserName());
        UserEntity registerdUser = authenticationService.signup(registerUserDto);
        int userId = registerdUser.getUserId();
        System.out.println(registerdUser.getUserId());
        return new ResponseEntity<>(
                new StandardResponse(200,"Sign up succesfull",userId),
                HttpStatus.CREATED
        );
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUserDto loginUserDto){

        UserEntity authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);


    }


}
