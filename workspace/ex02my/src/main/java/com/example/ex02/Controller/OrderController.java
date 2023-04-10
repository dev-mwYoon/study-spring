package com.example.ex02.Controller;

import com.example.ex02.domain.vo.OrderVO;
import com.example.ex02.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/order/*")
@RequiredArgsConstructor
public class OrderController {
    private final OrderMapper orderMapper;

//    추가
    @GetMapping("insert")
    public void insert(Model model){
        model.addAttribute(new OrderVO());
    }
    @PostMapping("insert")
    public RedirectView insert(OrderVO orderVO){
        orderMapper.insert(orderVO);

        return new RedirectView("/order/list");
    }

//    삭제
    @PostMapping("delete")
    public RedirectView delete(Long orderId){
        orderMapper.delete(orderId);
        return new RedirectView("/order/list");
    }

//    조회
    @GetMapping("detail")
    public void showDetail(Model model, Long orderId){
        model.addAttribute("order", orderMapper.select(orderId));
    }

//    목록
    @GetMapping("list")
    public void showLIst(Model model){
        model.addAttribute("orders", orderMapper.selectAll());
    }

}
