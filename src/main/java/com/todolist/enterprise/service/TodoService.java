package com.todolist.enterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.enterprise.dao.TaskRepository;
import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;

@Component
public class TodoService implements ITodoService {
    private final TaskRepository taskRepository;

    @Autowired
    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public List<Task> getTasksInTodoList(int todoListId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTasksInTodoList'");
    }

    @Override
    public Task createTask(Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTask'");
    }

    @Override
    public Task modifyTask(Task task) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyTask'");
    }

    @Override
    public void deleteTask(int taskId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTask'");
    }

    @Override
    public TodoList getTodoListById(int todoListId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListById'");
    }

    @Override
    public List<TodoList> getTodoLists() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTodoLists'");
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTodoList'");
    }

    @Override
    public TodoList modifyTodoList(TodoList todoList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyTodoList'");
    }

    @Override
    public void deleteTodoList(int todoListId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTodoList'");
    }
    
}
