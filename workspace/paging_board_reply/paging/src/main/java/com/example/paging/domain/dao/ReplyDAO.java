package com.example.paging.domain.dao;

import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.ReplyDTO;
import com.example.paging.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;
//    댓글 전체 조회
    public List<ReplyDTO> findAll(Criteria criteria, Long boardId){
        return replyMapper.selectAll(criteria, boardId);
    }

//    댓글 전체 개수
    public int findCountAll(Long boardId){
        return replyMapper.getTotal(boardId);
    }
}
