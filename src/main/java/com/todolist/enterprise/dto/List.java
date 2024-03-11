package com.todolist.enterprise.dto;
import lombok.Data;

public @Data class List {
    private int listId;
    private String name;
    private String description;
}
