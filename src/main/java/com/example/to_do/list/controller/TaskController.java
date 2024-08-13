package com.example.to_do.list.controller;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.service.TaskService;
import com.example.to_do.list.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping
    public ResponseEntity<StandardResponse> getTaskID(){
        TaskDTO taskDTO = taskService.getTasks(1);
        if (taskDTO != null){
            return new ResponseEntity<>(
                    new StandardResponse(201,"data found", taskDTO),
                    HttpStatus.FOUND
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(500,"no data found", null),
                    HttpStatus.NOT_FOUND
            );
        }

    }
}
