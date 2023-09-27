package com.example.todo.home.controller;

import com.example.todo.home.Entity.HomeEntity;
import com.example.todo.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {


    private final HomeService homeService;

    //접속시 hello 출력
    @GetMapping
    public ResponseEntity <?> home(){
        String str = "hello";
        return ResponseEntity.ok(str);
    }
    //id를 riturn
    @GetMapping("/{id}")
    public ResponseEntity<?> findHome(@PathVariable Long id) {
        HomeEntity homes = homeService.findHome(id);
        return ResponseEntity.ok(homes);
    }
    //keyword?content=입력한 값을 return
    @GetMapping("/keyword")
    public ResponseEntity<?> callparam(@RequestParam String content) {
        return ResponseEntity.ok("Query parameter : " + content);
    }
//
//    @GetMapping("/post")
//    public ResponseEntity<?> postHome(@RequestParam String content) {
//        HomeEntity homes = homeService.createHome(content);
//        return ResponseEntity.ok(homes);
//    }
    @PostMapping("/post")
    public ResponseEntity<?> postHome(@RequestParam String content) {
        HomeEntity homes = homeService.createHome(content);
        return ResponseEntity.ok(homes);
    }

}
