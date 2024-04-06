package com.todolist.enterprise;
import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;
import com.todolist.enterprise.service.ITodoService;


@Controller
public class TodoListController {

    @Autowired
    private ITodoService todoService;

    @GetMapping("/list/{id}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable("id") int id) {
        try {
            TodoList foundTodoList = todoService.getTodoListById(id);
            return new ResponseEntity<TodoList>(foundTodoList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lists")
    public ResponseEntity<List<TodoList>> getTasksInTodoList() {
        try {
            List<TodoList> foundLists = todoService.getTodoLists();
            return new ResponseEntity<List<TodoList>>(foundLists, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/list/new")
    public ResponseEntity<TodoList> createTodoList(@RequestBody TodoList todoList) {
        try {
            TodoList createdTodoList = todoService.createTodoList(todoList);
            return new ResponseEntity<TodoList>(createdTodoList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/list")
    public ResponseEntity<TodoList> updateTodoList(@RequestBody TodoList todoList) {
        try {
            TodoList updatedTodoList = todoService.modifyTodoList(todoList);
            return new ResponseEntity<TodoList>(updatedTodoList, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable("id") int id) {
        try {
            List<Task> tasksInListToDelete = todoService.getTasksInTodoList(id);

            tasksInListToDelete.forEach(task -> {
                todoService.deleteTask(task.getTaskId());
            });

            todoService.deleteTodoList(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
