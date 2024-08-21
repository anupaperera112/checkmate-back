package com.example.to_do.list.controller;

import com.example.to_do.list.DTO.TaskDTO;
import com.example.to_do.list.service.TaskService;
import com.example.to_do.list.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/getTask/{taskId}")
   public ResponseEntity<StandardResponse> getTaskByID(@PathVariable("taskId") int taskId){
        TaskDTO taskDTO = taskService.getTasks(taskId);
        if (taskDTO != null){
            return new ResponseEntity<>(
                    new StandardResponse(200,"data found", taskDTO),
                    HttpStatus.OK
            );
        }else{
            return new ResponseEntity<>(
                    new StandardResponse(404,"no data found", null),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping(value = "/createTask")
    public ResponseEntity<StandardResponse> CreateTask(@RequestBody TaskDTO taskDTO){
        System.out.println("Hey");
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

    @PatchMapping(value="/updateTask/{taskId}")
    public ResponseEntity<StandardResponse> updateTask(@PathVariable("taskId") int taskId, @RequestBody TaskDTO taskDTO){
        System.out.println(taskDTO.getTaskStatus() + "1");
        TaskDTO updated_task = taskService.updateTask(taskId,taskDTO);
        System.out.println(taskDTO.getTaskStatus() +"2");

        if (updated_task != null){
            return new ResponseEntity<>(
                    new StandardResponse(200,"successfully updated.",updated_task),
                    HttpStatus.OK
            );
        }else {
            return new ResponseEntity<>(
                    new StandardResponse(500,"update unsuccesfull",null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }

    }


}
