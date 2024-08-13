package com.example.to_do.list.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hello");
    }
}
