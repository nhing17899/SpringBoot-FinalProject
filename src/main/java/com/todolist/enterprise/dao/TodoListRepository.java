package com.todolist.enterprise.dao;


import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todolist.enterprise.dto.TodoList;

@Repository
@Profile("!test")
public interface TodoListRepository extends CrudRepository<TodoList, Integer>{

}
