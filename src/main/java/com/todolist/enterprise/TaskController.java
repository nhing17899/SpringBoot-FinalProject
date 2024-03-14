package com.todolist.enterprise;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {
    /**
     * Manages root endpoint and return to home page
     * @return Home page
     */
    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/task/{id}")
    public ResponseEntity getTaskById(@PathVariable("id") int id) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
