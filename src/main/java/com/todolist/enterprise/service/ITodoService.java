package com.todolist.enterprise.service;

import com.todolist.enterprise.dto.Task;

public interface ITodoService {
    /**
     * Fetch a todo task with a given ID.
     * @param taskId a unique identifier for a recipe
     * @return the matching task, or null if no matches found
     * @throws RuntimeException if the task with the given ID is not found
     *                          or if the provided task ID is invalid
     */
    Task getTaskById(int taskId);
}
