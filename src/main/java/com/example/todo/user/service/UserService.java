package com.example.todo.user.service;

import com.example.todo.user.dto.UserRequest;
import com.example.todo.user.dto.UserResponseDto;
import com.example.todo.user.entity.UserEntity;
import com.example.todo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponseDto transUser(UserEntity users) {
        return new UserResponseDto(users.getId(), users.getAge(), users.getName(), users.getJob());

    }
    public UserResponseDto createUser(UserRequest request) {
        UserEntity users = UserEntity.builder()
                .age(request.getAge())
                .name(request.getName())
                .job(request.getJob())
                .build();
        UserEntity saveUser = userRepository.save(users);
        return transUser(saveUser);
        }

    public UserResponseDto findUser(Long id) {
        Optional<UserEntity> userOp = userRepository.findById(id);
        UserEntity users = userOp.orElseThrow( () -> new RuntimeException("Not Found"));
        return transUser(users);
    }

    public ResponseEntity<?> findAllUser() {
        List<UserEntity> userList = userRepository.findAll();
        List<UserResponseDto> userDtoList = new ArrayList<>();

        for (UserEntity user : userList) {
            UserResponseDto userDto = transUser(user);
            userDtoList.add(userDto);
        }
        return ResponseEntity.ok(userDtoList);
    }


    public UserResponseDto updateUser(Long id, @RequestBody UserRequest request) {
        Optional<UserEntity> userOp = userRepository.findById(id);
        UserEntity users = userOp.orElseThrow( () -> new RuntimeException("Not Found"));
        if (request.getAge() != null) {
            users.setAge(request.getAge());
        }
        if (request.getName() != null) {
            users.setName(request.getName());
        }
        if (request.getJob() != null) {
            users.setJob(request.getJob());
        }

        UserEntity updateUser = userRepository.save(users);
        return (transUser(updateUser));

    }

    public void removeUser(Long id) {
        Optional<UserEntity> userOp = userRepository.findById(id);
        UserEntity users = userOp.orElseThrow( () -> new RuntimeException("Not Found"));
        userRepository.delete(users);

    }
}
