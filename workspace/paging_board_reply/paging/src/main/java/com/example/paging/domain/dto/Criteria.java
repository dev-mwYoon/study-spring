package com.example.paging.domain.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Criteria {
    private int page;
    private int rowCount;
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private int offset;

    public void create(int total, int rowCount, int pageCount) {
        this.rowCount = rowCount;
        this.total = total;
        this.pageCount = pageCount;
        this.offset = (page - 1) * rowCount;
        this.endPage = (int)(Math.ceil(page / (double)pageCount)) * pageCount;
        this.startPage = endPage - pageCount + 1;
        this.realEnd = (int)(Math.ceil(total / (double)rowCount));
        if(realEnd < endPage) {
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        this.prev = startPage > 1;
        this.next = endPage < realEnd;
    }
}
