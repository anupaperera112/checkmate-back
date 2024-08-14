package com.example.to_do.list.controller;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.service.TaskService;
import com.example.to_do.list.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/createTask")
    public ResponseEntity<StandardResponse> CreateTask(@RequestBody TaskDTO taskDTO){
        int taskId = taskService.createTask(taskDTO);
        if (taskId > 0){ // handle the error TODO
            return new ResponseEntity<>(
                    new StandardResponse(200,"new task created", taskId),
                    HttpStatus.CREATED
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(500,"error while creating a new task", null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping(value = "delete/{taskId}")
    public ResponseEntity<StandardResponse> deleteTask(@PathVariable("taskId") int taskId){
        boolean isRemoved = taskService.deleteTask(taskId);
        if(isRemoved){
            return new ResponseEntity<>(
                    new StandardResponse(200,"task id " + taskId + " deleted", null),
                    HttpStatus.FOUND
            );
        }else {
            return new ResponseEntity<>(
                    new StandardResponse(500,"error while deleting task", null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
