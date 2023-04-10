package com.example.ex02.Controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@Slf4j
public class OrderControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    //    주문
//    주문완료
    @Test
    public void orderTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders      // 브라우저 키고 주소창에 커서 둠.
                .get("/order/") // 주소입력
                .param("productId", "3") //쿼리스트링 작성
                .param("productName", "감자")
                .param("productPrice", "1000")
                .param("productStock", "50")
        ).andReturn()       // 주소창 작성완료 후 엔터!
                .getModelAndView()
                .getModelMap() //모델이 잘 담겨있는지 확인하기 위해
                .toString();

        mockMvc.perform(MockMvcRequestBuilders.post("/order/")
                .param("productId", "3")
                .param("productCount", "20")
        ).andExpect(        // 리턴할게 없으니 Expect를 써서 리다이렉션만 확인하기 위해
                MockMvcResultMatchers.status()
                        .is3xxRedirection());    // 3으로 시작하면 리다이렉션
    }

    //    주문내역
    @Test
    public void showListTest() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/order/list")).andReturn().getModelAndView().getModelMap().toString());
    }

    //    취소
    @Test
    public void cancelTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/order/cancel")
                .param("orderId", "3")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}
