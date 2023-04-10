package com.example.paging.mapper;

import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.ReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    댓글 전체 조회
    public List<ReplyDTO> selectAll(@Param("cri") Criteria criteria, @Param("boardId") Long boardId);

//    댓글 전체 개수
    public int getTotal(Long boardId);
}
