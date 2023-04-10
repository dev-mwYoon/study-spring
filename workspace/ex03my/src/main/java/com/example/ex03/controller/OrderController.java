package com.example.ex03.controller;

import com.example.ex03.domain.dto.OrderDTO;
import com.example.ex03.domain.vo.OrderVO;
import com.example.ex03.service.OrderService;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {
    private final OrderService orderService;
    private final ProductService productService;

//    추가
    @PostMapping("register")
    public OrderVO order(OrderVO orderVO){
        orderService.order(orderVO);
        return orderVO;
    }
//    삭제
    @DeleteMapping("delete/{orderId}")
    public String delete(@PathVariable("orderId") Long orderId){
        orderService.cancle(orderId);
        return "orderId: " + orderId;
    }
//    조회
    @GetMapping("detail/{orderId}")
    public OrderDTO detail(@PathVariable("orderId") Long orderId){
        return orderService.getOrder(orderId);
    }
//    목록
    @GetMapping("list")
    public List<OrderDTO> showList(){
        return orderService.getList();
    }

}
