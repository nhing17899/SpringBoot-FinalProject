package com.todolist.enterprise.dto;

import lombok.Data;

public @Data class User {
    private int userId;
    private String username;
    private String password;
}
