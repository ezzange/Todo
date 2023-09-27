package com.example.todo.home.service;

import com.example.todo.home.Entity.HomeEntity;
import com.example.todo.home.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final HomeRepository homeRepository;

    public String callString(String string) {
        return string;
    }

    public HomeEntity createHome(String content) {
        HomeEntity homes = HomeEntity.builder()
                .content(content)
                .build();
        return homeRepository.save(homes);
    }
    public HomeEntity findHome(Long id) {
        return homeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));

    }

}
