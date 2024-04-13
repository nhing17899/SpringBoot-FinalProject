package com.todolist.enterprise;
import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.service.ITodoService;


@Controller
public class TaskController {

    @Autowired
    private ITodoService todoService;

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id) {
    try {
        Task foundTask = todoService.getTaskById(id);
        return new ResponseEntity<>(foundTask, HttpStatus.OK);
    } catch (EntityNotFoundException e) {
        // Return a ResponseEntity with the status HttpStatus.NOT_FOUND
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (DataAccessException e) {
        // Return a ResponseEntity with the status HttpStatus.INTERNAL_SERVER_ERROR
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    @GetMapping("/list/{id}/tasks")
    public ResponseEntity<List<Task>> getTasksInTodoList(@PathVariable("id") int id) {
        try {
            List<Task> foundTasks = todoService.getTasksInTodoList(id);
            return new ResponseEntity<List<Task>>(foundTasks, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/task/new")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        try {
            Task createdTask = todoService.createTask(task);
            return new ResponseEntity<Task>(createdTask, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        try {
            Task updatedTask = todoService.modifyTask(task);
            return new ResponseEntity<Task>(updatedTask, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
        try {
            todoService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
