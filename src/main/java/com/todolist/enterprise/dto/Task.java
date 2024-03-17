package com.todolist.enterprise.dto;

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Task {
    @SerializedName("id")
    private int taskId;
    @SerializedName("name")
    private String name;
    @SerializedName("dueDate")
    private Date dueDate;
    @SerializedName("completed")
    private boolean completed;
    @SerializedName("listId")
    private int listId;
    @SerializedName("listOrder")
    private int listOrder;
}
