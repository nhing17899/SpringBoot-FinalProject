package com.todolist.enterprise.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.enterprise.dto.Task;

@Repository
@Profile("!test")
public interface TaskRepository extends CrudRepository<Task, Integer>{
    
    List<Task> findAllByListId(int todoListId);

}
