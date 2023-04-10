package com.example.ex05my.domain.dao;

import com.example.ex05my.domain.vo.FileVO;
import com.example.ex05my.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    //    파일 추가
    public void save(FileVO fileVO){
        fileMapper.insert(fileVO);
    };

    //    파일 전체 조회
    public List<FileVO> findByBoardId(Long boardId) {
        return fileMapper.selectAll(boardId);
    }

    //    파일 삭제
    public void deleteByBoardId(Long boardId) {
        fileMapper.delete(boardId);
    }
}
