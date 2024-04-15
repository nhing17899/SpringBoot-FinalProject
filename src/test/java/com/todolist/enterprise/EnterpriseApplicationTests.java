package com.todolist.enterprise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.todolist.enterprise.dto.TodoList;
import com.todolist.enterprise.service.ITodoService;
import org.junit.jupiter.api.Assertions;
import com.todolist.enterprise.service.TodoService;
import java.util.List;

@SpringBootTest
class EnterpriseApplicationTests {


	@Autowired
	private ITodoService todoService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateTodoList() {
		TodoList todoList = new TodoList();
		todoList.setName("Test TodoList");
		todoList.setDescription("Test Description");

		todoService.createTodoList(todoList);

	}



	@Test
	void testGetTodoLists() {
		TodoList todoList1 = new TodoList();
		todoList1.setName("ToDoList test number 1");
		todoList1.setDescription("ToDoList Description 1");

		List<TodoList> todoLists = todoService.getTodoLists();
	}

}
