package com.example.todo.todo.controller;

import com.example.todo.todo.Dto.TodoRequest;
import com.example.todo.todo.Dto.TodoResponseDto;
import com.example.todo.todo.Entity.TodoEntity;
import com.example.todo.todo.repogitory.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    //todo list 조회
    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        List<TodoEntity> todoList = todoRepository.findAll();
        List<TodoResponseDto> dtoList = new ArrayList<>();

        for (TodoEntity entity : todoList) {
            TodoResponseDto dto = transTodo(entity);
            dtoList.add(dto);
        }
        return ResponseEntity.ok(todoList);
    }

    //해당 id의 todo 조회
    @GetMapping("/{id}")
    public ResponseEntity <?> findTodo(@PathVariable Long id) {
        Optional<TodoEntity> optionalTodos = todoRepository.findById(id);
        TodoEntity todos = optionalTodos.orElseThrow(() -> new RuntimeException("Not Found"));
        TodoResponseDto responseDto = transTodo(todos);
        return ResponseEntity.ok(responseDto);
    }

    //todo 생성
    @PostMapping
    public ResponseEntity<?> postTodos(@RequestBody TodoRequest request){
        TodoEntity todos = TodoEntity.builder()
                .title(request.getTitle())
                .completed(request.getCompleted())
                .build();
        TodoEntity saveTodos = todoRepository.save(todos);
        TodoResponseDto responseDto = transTodo(saveTodos);
        return ResponseEntity.ok(responseDto);
    }

    //todo 수정
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateTodoById(
            @PathVariable Long id,
            @RequestBody TodoRequest request
    ){
        Optional<TodoEntity> optionalTodos = todoRepository.findById(id);
        TodoEntity todos = optionalTodos.orElseThrow(() -> new RuntimeException("Not Found"));
        if (request.getTitle() != null) {
            todos.setTitle(request.getTitle());
        }
        if(request.getCompleted() != null){
            todos.setCompleted(request.getCompleted());
        }
        TodoEntity reUpTodos = todoRepository.save(todos);

        TodoResponseDto responseDto = transTodo(reUpTodos);
        return ResponseEntity.ok(responseDto);
    }
    //todo  삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodos(@PathVariable Long id) {
        Optional<TodoEntity> optionalTodos = todoRepository.findById(id);
        TodoEntity todos = optionalTodos.orElseThrow(() -> new RuntimeException("Not Found"));
        todoRepository.deleteById(id);
        return ResponseEntity.ok(todos+"삭제 완료");

    }
    //TodoEntity를 Dto로 변환한 메서드
    public TodoResponseDto transTodo(TodoEntity todos) {
        return new TodoResponseDto(todos.getId(), todos.getTitle(), todos.getCompleted());
    }
}







