package com.example.ex02.service;

import com.example.ex02.domain.dao.ProductDAO;
import com.example.ex02.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Service @Qualifier
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    @Override
    public void registerProduct(ProductVO productVO) {

    }

    @Override
    public void updateProduct(ProductVO productVO) {

    }

    @Override
    public List<ProductVO> getList() {
        return null;
    }

    @Override
    public ProductVO getProduct(Long productId) {
        return null;
    }
}
