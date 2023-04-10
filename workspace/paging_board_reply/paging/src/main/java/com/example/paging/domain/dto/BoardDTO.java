package com.example.paging.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BoardDTO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private Integer boardGradeStar;
    private boolean boardStatus;
    private Long memberId;
    private String memberIdentification;
    private String memberNickname;
}
