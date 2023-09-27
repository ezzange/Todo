package com.example.todo.home.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class HomeServiceTest {

    @Autowired
    private HomeService homeService;

    @Test
    void test() {
        //given
        String result = homeService.callString("aa");
        //when
        assertThat(result).isEqualTo("aa");        //then
    }
}