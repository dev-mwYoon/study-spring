package com.example.paging.mapper;

import com.example.paging.domain.dto.BoardDTO;
import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.Search;
import com.example.paging.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
//    조회
    public BoardDTO select(Long boardId);

//    목록
    public List<BoardDTO> selectAll(@Param("cri") Criteria criteria, @Param("search") Search search);

//    전체 개수
    public int selectTotal(@Param("search") Search search);
}
