package com.example.ex02.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderDTO {
    private Long orderId;
    private String orderDate;
    private Long productId;
    private Integer productCount;
    private String productName;
    private Integer productPrice;
    private Integer productStock;
    private Integer orderTotal;
//    public Integer getOrderTotal(){
//        return productPrice * productCount;
//    }
}
