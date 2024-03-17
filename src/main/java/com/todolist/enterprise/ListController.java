package com.todolist.enterprise;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Controller
public class ListController {

    @RequestMapping("/")
    public String index() {
        return "ListView";
    }
}
