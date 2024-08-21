package com.example.to_do.list.service.IMPL;

import com.example.to_do.list.entity.User;
import com.example.to_do.list.repository.UserRepository;
import com.example.to_do.list.service.UserService;
import com.example.to_do.list.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public int addUser(UserDTO userDTO){
        User user = new User();
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserName(user.getUserName());
        user.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));

        userRepository.save(user);
        return user.getUserId();
    }


}
