package com.example.paging.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReplyVO {
    private Long replyId;
    private String replyContent;
    private Long boardId;
    private Long memberId;
}
