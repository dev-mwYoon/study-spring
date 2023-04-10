package com.example.paging.controller;

import com.example.paging.domain.dto.Criteria;
import com.example.paging.domain.dto.Search;
import com.example.paging.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
    private final BoardService boardService;

//    전체 조회
    @GetMapping("list")
    public void showList(Criteria criteria, Search search, Model model){
        log.info(search.toString());
        model.addAttribute("boards", boardService.getList(criteria, search));
    }

//    조회
    @GetMapping("/detail")
    public void showDetail(Long boardId, Model model){
        model.addAttribute(boardService.getBoard(boardId));
    }


}




















