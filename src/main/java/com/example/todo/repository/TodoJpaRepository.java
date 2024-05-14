package com.example.todo.repository;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Integer> {

}