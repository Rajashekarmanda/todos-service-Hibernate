package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class TodoJpaService implements TodoRepository {
	@Autowired
	public TodoJpaRepository todoJpaRepository;

	@Override
	public ArrayList<Todo> getTodos() {
		List<Todo> todosList = todoJpaRepository.findAll();
		ArrayList<Todo> todos = new ArrayList<>(todosList);
		return todos;
	}

	@Override
	public Todo getTodoDetails(int todoId) {
		try {
			Todo todo = todoJpaRepository.findById(todoId).get();
			return todo;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Todo addTodo(Todo todo) {
		Todo savedTodo = todoJpaRepository.save(todo);
		return savedTodo;
	}

	@Override
	public Todo updateTodo(int todoId, Todo todo) {
		try {
			Todo savedTodo = todoJpaRepository.findById(todoId).get();
			if (savedTodo.getStatus() != null) {
				savedTodo.setStatus(todo.getStatus());
			}
			todoJpaRepository.save(savedTodo);
			return savedTodo;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteTodo(int todoId) {
		try {
			todoJpaRepository.deleteById(todoId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
}
