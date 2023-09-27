package com.example.todo.user.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Job {
    STUDENT("STUDENT"), ENGINEER("ENGINEER"), TEACHER("TEACHER");

    private final String job;
}
