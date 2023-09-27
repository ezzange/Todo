package com.example.todo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto<T> {//응답 데이터와 상태를 담아 포장

    @Schema(description = "Result Data")
    private Result result;
    @Schema(description = "Response Data Body")
    private T data;

    public static <T> ResponseDto<T> of(T data, Result result) {
        ResponseDto<T> response = new ResponseDto<>();
        response.result =result;
        response.data= data;
        return response;
    }

    public static <T> ResponseDto<T> of(Result result) {
        ResponseDto<T> response = new ResponseDto<>();
        response.result = result;
        response.data = null;
        return response;
    }


}
