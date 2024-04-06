package com.todolist.enterprise.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;

import java.util.Date;
import java.util.List;

@Component
@Profile("test")
public class TodoServiceStub implements ITodoService {
    @Override
    public Task getTaskById(int taskId) {
        if (taskId == 1) {
            Task task = new Task();
            task.setName("Task 1");
            task.setDueDate(new Date());
            task.setCompleted(false);
            task.setListId(1);

            return task;
        }
        
        return null;
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