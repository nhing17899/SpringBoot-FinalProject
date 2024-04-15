package com.todolist.enterprise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

    @GetMapping("/")
    public String redirectToLists(Model model) {
        return "redirect:/lists";
    }

    @GetMapping("/lists/{id}")
    public String getTodoListById(@PathVariable("id") int id, Model model) {
        TodoList foundTodoList = todoService.getTodoListById(id);
        model.addAttribute("todoList", foundTodoList);
        return "listDetail";
    }

    @GetMapping("/lists")
    public String getTasksInTodoList(Model model) {
        List<TodoList> foundLists = todoService.getTodoLists();
        model.addAttribute("todoLists", foundLists);
        return "home";
    }

    @PostMapping("/list/create")
    public String createTodoList(@ModelAttribute TodoList todoList, Model model) {
        todoService.createTodoList(todoList);

        List<TodoList> foundLists = todoService.getTodoLists();
        model.addAttribute("todoLists", foundLists);
        return "redirect:/lists";
    }

    @PutMapping("/")
    public ResponseEntity<TodoList> updateTodoList(@RequestBody TodoList todoList) {
        try {
            TodoList updatedTodoList = todoService.modifyTodoList(todoList);
            return new ResponseEntity<TodoList>(updatedTodoList, HttpStatus.OK);
        } catch (Exception e) {
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
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
