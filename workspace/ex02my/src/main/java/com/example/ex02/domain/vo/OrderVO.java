package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderVO {
    private Long orderId;
    private Long productId;
    private String orderDate;
    private Integer productCount;
}
