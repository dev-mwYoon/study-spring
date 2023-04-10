package com.example.paging.domain.dao;

import com.example.paging.domain.dto.BoardDTO;
import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.Search;
import com.example.paging.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

//    조회
    public BoardDTO findById(Long boardId){
        return boardMapper.select(boardId);
    }

//    목록
    public List<BoardDTO> findAll(Criteria criteria, Search search){
        return boardMapper.selectAll(criteria, search);
    }

//    전체 개수
    public int findCountAll(Search search){
        return boardMapper.selectTotal(search);
    }
}

















