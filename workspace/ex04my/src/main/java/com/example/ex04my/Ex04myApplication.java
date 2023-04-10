package com.example.ex04my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // main서버에 프록시 생성 허용 시켜주는 어노테이션
@SpringBootApplication
public class Ex04myApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex04myApplication.class, args);
    }

}
