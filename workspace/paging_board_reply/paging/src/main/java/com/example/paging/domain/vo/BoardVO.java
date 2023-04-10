package com.example.paging.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardVO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private Integer boardGradeStar;
    private boolean boardStatus;
    private Long memberId;
}
