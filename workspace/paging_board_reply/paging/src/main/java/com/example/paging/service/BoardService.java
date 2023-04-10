package com.example.paging.service;

import com.example.paging.domain.dao.BoardDAO;
import com.example.paging.domain.dto.BoardDTO;
import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDAO boardDAO;

//    조회
    public BoardDTO getBoard(Long boardId){
        return boardDAO.findById(boardId);
    }

//    목록
    public List<BoardDTO> getList(Criteria criteria, Search search){
        criteria.create(getTotal(search));
        return boardDAO.findAll(criteria, search);
    }

//    전체 개수
    public int getTotal(Search search){
        return boardDAO.findCountAll(search);
    }
}
