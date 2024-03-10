package com.todolist.enterprise.dto;

import java.util.Date;
import lombok.Data;

public @Data class Task {
    private int taskId;
    private String name;
    private Date dueDate;
    private boolean completed;
    private int listId;
    private int listOrder;
}
