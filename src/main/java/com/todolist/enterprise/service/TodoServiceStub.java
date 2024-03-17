package com.todolist.enterprise.service;
import org.springframework.stereotype.Component;
import com.todolist.enterprise.dto.Task;
import java.util.Date;

@Component
public class TodoServiceStub implements ITodoService {
    @Override
    public Task getTaskById(int taskId) {

        Task task = new Task();
        task.setName("Task 1");
        task.setDueDate(new Date());
        task.setCompleted(false);
        task.setListId(1);

        return task;
    }
}