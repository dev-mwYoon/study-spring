package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.Logger;

@SpringBootTest
@Slf4j
public class DependencyTests {

    @Autowired // injection 요청
    Coding coding;

    @Autowired
    Restaurant restaurant;

    @Autowired
    School school;

    @Autowired
    Teacher teacher;

    @Autowired
    Student student;

    @Test
    public void testCoding(){
//        Logger logger -> 로그 객체 생성해줘야하지만 @Slf4j 어노테이션만 해줘도 log.info()사용가능
//        log.info(coding.toString());        이렇게 하면 NPE(null point exception) 방어 안됨
        log.info(String.valueOf(coding)); // NPE 방어됨
    }

    @Test
    public void testRestaurant(){
        log.info(String.valueOf(restaurant));
    }

    @Test
    public void testSchool(){
        log.info(String.valueOf(school));
    }

    @Test
    public void testStudent(){
        log.info(String.valueOf(student));
    }

    @Test
    public void testTeacher(){
        log.info(String.valueOf(teacher));
    }

}
