package com.example.ex03.mapper;

import com.example.ex03.domain.dto.OrderDTO;
import com.example.ex03.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //    추가
    public void insert(UserVO userVO);
    //    조회(총 결제 금액까지)
    public UserVO select(Long userId);
    //    목록(총 결제 금액까지)
    public List<UserVO> selectAll();
}
