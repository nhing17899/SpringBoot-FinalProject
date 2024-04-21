package com.todolist.enterprise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todolist.enterprise.dao.TaskRepository;
import com.todolist.enterprise.dao.TodoListRepository;
import com.todolist.enterprise.dto.Task;
import com.todolist.enterprise.dto.TodoList;

@Component
public class TodoService implements ITodoService {
    private final TaskRepository taskRepository;
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoService(TaskRepository taskRepository, TodoListRepository todoListRepository) {
        this.taskRepository = taskRepository;
        this.todoListRepository = todoListRepository;
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public List<Task> getTasksInTodoList(int todoListId) {
        //updated the method call to use the new method name in TaskRepository
        return taskRepository.findAllByListId(todoListId);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task modifyTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TodoList getTodoListById(int todoListId) {
        return todoListRepository.findById(todoListId).get();
    }

    @Override
    public List<TodoList> getTodoLists() {
        Iterable<TodoList> todoListsIterable =  todoListRepository.findAll();
        List<TodoList> todoLists = new ArrayList<TodoList>();
        todoListsIterable.forEach(list -> {
            todoLists.add(list);
        });
        

        return todoLists;
    }

    @Override
    public TodoList createTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public TodoList modifyTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @Override
    public void deleteTodoList(int todoListId) {
        todoListRepository.deleteById(todoListId);
    }
}
