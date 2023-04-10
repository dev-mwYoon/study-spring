package com.example.ex05my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Test {
    @PostMapping("/test")
    public void test(int data){

    }
}
