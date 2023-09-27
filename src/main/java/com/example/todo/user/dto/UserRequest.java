package com.example.todo.user.dto;

import com.example.todo.user.entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private Long age;
    private String name;
    private Job job;


}
