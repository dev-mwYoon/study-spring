package com.example.paging.controller;

import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.ReplyDTO;
import com.example.paging.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
    private final ReplyService replyService;

//    댓글 전체 조회
    @GetMapping("list")
    public List<ReplyDTO> showList(Criteria criteria, Long boardId){
        return replyService.getList(criteria, boardId);
    }

}
