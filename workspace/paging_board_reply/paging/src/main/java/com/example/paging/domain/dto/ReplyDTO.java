package com.example.paging.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyDTO {
    private Long replyId;
    private String replyContent;
    private Long boardId;
    private Long memberId;
    private String memberNickname;
}
