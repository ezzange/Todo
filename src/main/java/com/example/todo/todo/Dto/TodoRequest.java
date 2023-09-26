package com.example.todo.todo.Dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TodoRequest {
    private String title;
    private Boolean completed;
}