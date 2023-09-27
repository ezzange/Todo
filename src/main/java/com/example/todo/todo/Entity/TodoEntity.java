package com.example.todo.todo.Entity;

import com.example.todo.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean completed;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private UserEntity user;

    public void addUser(UserEntity user) {
        this.user = user;
        user.addTodo(this);
    }

}
