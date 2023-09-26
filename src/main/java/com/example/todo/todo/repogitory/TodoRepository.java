package com.example.todo.todo.repogitory;

import com.example.todo.todo.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository< TodoEntity, Long > {

}
