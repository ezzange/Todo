package com.example.todo.todo.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TodoResponseDto {
    private Long id;
    private String title;
    private Boolean completed;

    public TodoResponseDto(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

}
