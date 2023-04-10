package com.example.ex03.controller;

import com.example.ex03.domain.vo.ProductVO;
import com.example.ex03.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {
    private final ProductService productService;

//    상품 추가
    @PostMapping("insert")
    public ProductVO insert(ProductVO productVO) {
        productService.registerProduct(productVO);
        return productVO;
    }
//    상품 전체 수정
    @PutMapping("update/products/{productId}")
    public String updateAll(@PathVariable("productId") Long productId, ProductVO productVO) {
        productService.updateProduct(productVO);
        return "전체 수정: " + productId + productVO;
    }

//    상품 부분 수정
    @PatchMapping("update/products/{productId}")
    public String update(@PathVariable("productId") Long productId, ProductVO productVO) {
        ProductVO originalVO = productService.getProduct(productId);

        if(productVO.getProductName() != null) {
            originalVO.setProductName(productVO.getProductName());
        }else if(productVO.getProductPrice() != null) {
            originalVO.setProductPrice(productVO.getProductPrice());
        }else if(productVO.getProductStock() != null) {
            originalVO.setProductStock(productVO.getProductPrice());
        }

        productService.updateProduct(originalVO);
        return "부분 수정: " + productId + originalVO;
    }

//    상품 목록
    @PostMapping("list")
    public List<ProductVO> showList(){
        return productService.getList();
    }

//    상품 조회
    @PostMapping("detail")
    public ProductVO detail(Long productId) {
        return productService.getProduct(productId);
    }
}
