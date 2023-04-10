package com.example.ex03.controller;

import com.example.ex03.domain.vo.UserVO;
import com.example.ex03.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/*")
public class UserController {
    private final UserService userService;

    @PostMapping("register")
    public UserVO register(UserVO userVO){
        userService.register(userVO);
        return userVO;
    }
    @GetMapping("detail/{userId}")
    public UserVO showUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }
    @GetMapping("list")
    public List<UserVO> showList(){
        return userService.getList();
    }
}
