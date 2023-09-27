package com.example.todo.user.dto;

import com.example.todo.user.entity.Job;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "회원 응답 Data")
@Builder
public class UserResponseDto {

    @Schema(description = "회원 식별자")
    private Long id;
    @Schema(description = "회원 나이")
    private Long age;
    @Schema(description = "회원 이름")
    private String name;
    @Schema(description = "회원 직업")
    private Job job;


    public UserResponseDto(Long id, Long age, String name, Enum job) {
    }
}
