package com.example.paging.controller;

import com.example.paging.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {
    private final MemberVO memberVO;

    @GetMapping("login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String memberId = null, memberPassword = null;
        for(Cookie cookie : request.getCookies()){
            if(cookie.getName().equals("memberId")){
                memberId = cookie.getValue();
            }
            if(cookie.getName().equals("memberPassword")){
                memberPassword = cookie.getValue();
            }
        }

        if(memberId != null){
            redirectAttributes.addAttribute("memberId", memberId);
            redirectAttributes.addAttribute("memberPassword", memberPassword);
            return "redirect:/member/login";
        }
        return "/member/login";
    }

    public void login(String memberId, String memberPassword, HttpSession session){

    }
}















