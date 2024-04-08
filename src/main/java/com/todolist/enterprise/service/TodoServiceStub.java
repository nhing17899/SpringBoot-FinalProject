package com.todolist.enterprise.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;

import java.util.ArrayList;
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
        if (todoListId == 1) {
            List<Task> tasks = new ArrayList<Task>();
            for (int i = 1; i <= 10; i++) {
                Task task = new Task();
                task.setTaskId(i);
                task.setName("task " + i);
                task.setDueDate(new Date());
                task.setCompleted(i % 2 == 0);
                task.setListId(1);
                task.setListOrder(i);
    
                tasks.add(task);
            }

            return tasks;
        }
        
        return null;
    }

    @Override
    public Task createTask(Task task) {
        return task;
    }

    @Override
    public Task modifyTask(Task task) {
        return task;
    }

    @Override
    public void deleteTask(int taskId) { }

    @Override
    public TodoList getTodoListById(int todoListId) {
        if (todoListId == 1) {
            TodoList todoList = new TodoList();
            todoList.setListId(1);
            todoList.setName("List 1");
            todoList.setDescription("List 1 Description");

            return todoList;
        }
        
        return null;
    }

    @Override
    public List<TodoList> getTodoLists() {
        List<TodoList> todoLists = new ArrayList<TodoList>();
        for (int i = 1; i <= 10; i++) {
            TodoList todoList = new TodoList();
            todoList.setListId(i);
            todoList.setName("List " + i);
            todoList.setDescription("List " + i + " Description");

            todoLists.add(todoList);
        }

        return todoLists;
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        return todoList;
    }

    @Override
    public TodoList modifyTodoList(TodoList todoList) {
       return todoList;
    }

    @Override
    public void deleteTodoList(int todoListId) { }
}