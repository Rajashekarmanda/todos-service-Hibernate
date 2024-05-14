package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {
    @Autowired
    public TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoJpaService.getTodos();
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodoDetails(@PathVariable("todoId") int todoId) {
        return todoJpaService.getTodoDetails(todoId);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int todoId, @RequestBody Todo todo) {
        return todoJpaService.updateTodo(todoId, todo);
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoId) {
        todoJpaService.deleteTodo(todoId);
    }
}