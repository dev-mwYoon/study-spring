package com.example.ex03.domain.dao;

import com.example.ex03.domain.vo.UserVO;
import com.example.ex03.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;
    //    추가
    public void save(UserVO userVO){
        userMapper.insert(userVO);
    }
    //    조회(총 결제 금액까지)
    public UserVO findById(Long userId) {
        return userMapper.select(userId);
    }
    //    목록(총 결제 금액까지)
    public List<UserVO> findAll() {
        return userMapper.selectAll();
    }
}
