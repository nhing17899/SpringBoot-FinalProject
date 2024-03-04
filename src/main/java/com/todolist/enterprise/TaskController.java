package com.todolist.enterprise;
import org.springframework.stereotype.Controller;
import com.todolist.enterprise.dto.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {

    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/task/{id}")
    public ResponseEntity getTaskById(@PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
