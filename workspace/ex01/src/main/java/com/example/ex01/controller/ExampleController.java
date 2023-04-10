package com.example.ex01.controller;

import com.example.ex01.domain.MemberVO;
import com.example.ex01.domain.ProductVO;
import com.example.ex01.domain.TaskVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpClient;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public String ex01(){
        log.info("ex01..............");
        return "ex01";
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02..............");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request){
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(@ModelAttribute("name") String name/*, Model model*/){
//        model.addAttribute("name", name);
        log.info(name);
    }

    //    이름, 나이, 성별 받고 출력
    @GetMapping("ex05")
    public void ex05(MemberVO memberVO){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
    }

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, @RequestParam("address") String city/*, Model model*/){
        log.info("이름 : " + memberVO.getName());
        log.info("나이 : " + memberVO.getAge() + "살");
        log.info("성별 : " + memberVO.getGender());
        log.info("사는 도시 : " + city);
        /*model.addAttribute("city", city);*/
    }

    @GetMapping("ex07")
    public void ex07(String name, Integer age) {;}

    //    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
    @GetMapping("product")
    public String manageProduct(Model model){
        model.addAttribute(new ProductVO());
        return "/product/register";
    }

    @PostMapping("register")
    public RedirectView registerProduct(ProductVO productVO, RedirectAttributes redirectAttributes){
//        forward   : 그냥 리턴, .html로 즉시 이동
//        redirect  : RedirectView객체로 리턴, 생성자에 원하는 컨트롤러의 경로 작성, 컨트롤러에서 다시 Mapping

//        addAttribute() : URL뒤에 쿼리스트링을 붙여준다, 컨트롤러의 매개변수로 전달할 때 사용한다.

//        redirectAttributes.addAttribute("productName", productVO.getProductName());
//        redirectAttributes.addAttribute("productPrice", productVO.getProductPrice());
//        redirectAttributes.addAttribute("productStock", productVO.getProductStock());
//        redirectAttributes.addAttribute("productBrand", productVO.getProductBrand());

//        addFlashAttribute() : Flash 영역을 사용하여, 화면에 데이터를 전달할 때 사용한다.
        redirectAttributes.addFlashAttribute(productVO);
        return new RedirectView("/ex/list");
    }

    //    입력받은 상품명 수정 후 목록으로 출력
    @PostMapping("update")
    public RedirectView update(ProductVO productVO, RedirectAttributes redirectAttributes){
        productVO.setProductName("감자");
        redirectAttributes.addFlashAttribute(productVO);
        return new RedirectView("/ex/list");
    }


    @GetMapping("list")
    public String list(ProductVO productVO){
        return "/product/list";
    }


    //    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
    @GetMapping("task02")
    public String task02(Model model){
        model.addAttribute(new TaskVO());
        return "/task02/input";
    }

    @PostMapping("task02")
    public RedirectView task02(TaskVO taskVO, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute(taskVO);
        return new RedirectView("/ex/list02");
    }


    @GetMapping("list02")
    public String list(){
        return "/task02/list";
    }



    //    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력
    @GetMapping("login")
    public String task03(Model model){
        model.addAttribute(new MemberVO());
        return "task03/login";
    }
    @GetMapping("user")
    public String user(){
        return "task03/user";
    }
    @GetMapping("admin")
    public String admin(){
        return "task03/admin";
    }
    @PostMapping("task03")
    public RedirectView access(MemberVO memberVO, RedirectAttributes redirectAttributes){
        String path = null;
        RedirectView redirectView = null;
        redirectAttributes.addFlashAttribute(memberVO);

        if (memberVO.getIdentification().equals("admin")) {
            redirectView = new RedirectView("/ex/admin");
        } else if (memberVO.getIdentification().equals("user")) {
            redirectView = new RedirectView("/ex/user");
        } else {
            redirectView = new RedirectView("/ex/login");
        }
        return redirectView;
    }





    //    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html
//    - leaveWork.html
//    - late.html
//    - work.html
    @GetMapping("task04")
    public String task04(){
        return "/task04/task04";
    }

    @PostMapping("get-to-work")
    public String getToWork(){
//        LocalDateTime now = LocalDateTime.now();
//        int hour = now.getHour();
//        int minute = now.getMinute();



        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String target = "/task04/";
        target += hour < 9 || (hour == 9 && minute == 0) ? "get-to-Work" : "late";
        return target;
    }

    @PostMapping("leave-work")
    public String taskLeave(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        String target = "/task04/";
        target += hour > 16 ? "leave-work" : "work";
        return target;
    }
}