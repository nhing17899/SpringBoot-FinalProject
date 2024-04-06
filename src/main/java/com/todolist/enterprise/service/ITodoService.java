package com.todolist.enterprise.service;

import java.util.List;

import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;

public interface ITodoService {
    // Task Methods

    /**
     * Fetch a todo task with a given ID.
     * @param taskId id of the task to get
     * @return the matching task, or null if no matches found
     */
    public Task getTaskById(int taskId);

    /**
     * Fetch tasks within a todo list given a todo list's id
     * @param todoListId a unique identifier for a todo list
     * @return list of tasks that are in the specified todo list
     */
    public List<Task> getTasksInTodoList(int todoListId);
    
    /**
     * Creates a task
     * @param task The task to create
     * @return the created task
     */
    public Task createTask(Task task);

    /**
     * Updates a task
     * @param task task data to update
     * @return the updated task
     */
    public Task modifyTask(Task task);
    
    /**
     * Delete a task by id
     * @param taskId id of the task to delete
     */
    public void deleteTask(int taskId);

    // List Methods

    /**
     * Gets a todo list by id
     * @param todoListId id of the todo list to get
     * @return todo list
     */
    public TodoList getTodoListById(int todoListId);

    /**
     * Gets list of todo lists
     * @return list of todo lists
     */
    public List<TodoList> getTodoLists();
    
    /**
     * Creates a todo list
     * @param todoList todo list to create
     * @return todo list that was created
     */
    public TodoList createTodoList(TodoList todoList);

    /**
     * Updates a todo list
     * @param todoList todo list data to update
     * @return updated todo list
     */
    public TodoList modifyTodoList(TodoList todoList);

    /**
     * Deletes a todo list
     * @param todoListId id of the todo list to delete
     */
    public void deleteTodoList(int todoListId);
}