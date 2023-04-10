package com.example.ex01.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private String name;
    private Integer age;
    private String gender;
    private String identification;
    private String password;
}
