package com.example.todo.bean;

import com.example.todo.TodoApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class sampleTest {

    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(TodoApplication.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void allTest() {
        //given
        String[] beans = ac.getBeanDefinitionNames();
        //when
        //then
        for (String bean : beans) {
            System.out.println("bean name = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void appTest() {
        //given
        String[] beans = ac.getBeanDefinitionNames();
        //when
        //then
        for (String bean : beans) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(bean);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object beanOb = ac.getBean(bean);
                System.out.println("bean name = " + bean + "Object = "+bean);
            }
        }
    }
}
