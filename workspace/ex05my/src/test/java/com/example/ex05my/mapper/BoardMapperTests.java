package com.example.ex05my.mapper;

import com.example.ex05my.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    BoardMapper boardMapper;

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("테스트 제목1");
        boardVO.setBoardWriter("테스트1");
        boardVO.setBoardContent("테스트 제목1");

        boardMapper.insert(boardVO);

        assertThat(boardVO.getBoardId()).isEqualTo(1L);
    }

    @Test
    public void selectTest(){
        assertThat(boardMapper.select(1L).getBoardTitle()).isEqualTo("테스트 제목1");
    }

    @Test
    public void updateTest(){
        BoardVO boardVO = boardMapper.select(1L);

        boardVO.setBoardTitle("수정된 제목");
        boardVO.setBoardContent("수정된 내용1");

        boardMapper.update(boardVO);
    }

    @Test
    public void delete(){
        boardMapper.delete(1L);
    }

    @Test
    public void selectAllTest(){
        assertThat(boardMapper.selectAll().size()).isEqualTo(1);
    }
}
