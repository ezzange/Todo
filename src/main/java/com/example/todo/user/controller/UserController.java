package com.example.todo.user.controller;

import com.example.todo.dto.ResponseDto;
import com.example.todo.dto.Result;
import com.example.todo.user.dto.UserRequest;
import com.example.todo.user.dto.UserResponseDto;
import com.example.todo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    //user create
    @PostMapping
    public ResponseEntity<ResponseDto<UserResponseDto>> postUser(@RequestBody UserRequest request){
        //요청dto를 가지고 service에서 바로 유저응답dto로 생성
        UserResponseDto userDto = userService.createUser(request);
        //포장하기
        Result result = Result.create();
        ResponseDto<UserResponseDto> response = ResponseDto.of(userDto, result);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        ResponseEntity<?> userDtos = userService.findAllUser();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UserResponseDto>> getUser(@PathVariable Long id) {
        UserResponseDto userDto = userService.findUser(id);
        ResponseDto<UserResponseDto> response = ResponseDto.of(userDto, Result.ok());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDto<UserResponseDto>> patchUser(@PathVariable Long id, @RequestBody UserRequest request) {
        UserResponseDto userDto = userService.updateUser(id, request);
        ResponseDto<UserResponseDto> response = ResponseDto.of(userDto, Result.ok());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<UserResponseDto>> deleteUser(@PathVariable Long id) {
       userService.removeUser(id);
        return ResponseEntity.ok(ResponseDto.of(Result.ok()));
    }


}
