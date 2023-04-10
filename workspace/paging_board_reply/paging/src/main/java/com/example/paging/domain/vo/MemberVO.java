package com.example.paging.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long memberId;
    private String memberIdentification;
    private String memberPassword;
    private String memberNickname;
}
