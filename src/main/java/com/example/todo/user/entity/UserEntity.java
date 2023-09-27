package com.example.todo.user.entity;

import com.example.todo.todo.Entity.TodoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Getter
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long age;

    @Column
    @Enumerated(EnumType.STRING)
    private Job job;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id")
    private Set<TodoEntity> todos = new LinkedHashSet<>();

    public void addTodo(TodoEntity todo){
        this.todos.add(todo);
    }


    public void setAge(Long age) {
    }

    public void setName(String name) {
    }

    public void setJob(Job job) {
    }
}
