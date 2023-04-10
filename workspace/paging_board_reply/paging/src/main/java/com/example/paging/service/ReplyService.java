package com.example.paging.service;

import com.example.paging.domain.dao.ReplyDAO;
import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.ReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyDAO replyDAO;
    //    댓글 전체 조회
    public List<ReplyDTO> getList(Criteria criteria, Long boardId){
        criteria.create(getTotal(boardId));
        return replyDAO.findAll(criteria, boardId);
    }
    
//    댓글 전체 개수
    public int getTotal(Long boardId){
        return replyDAO.findCountAll(boardId);
    }
}
