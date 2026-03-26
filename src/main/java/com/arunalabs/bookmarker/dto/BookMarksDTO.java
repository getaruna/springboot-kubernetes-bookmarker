package com.arunalabs.bookmarker.dto;

import com.arunalabs.bookmarker.domain.BookMark;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class BookMarksDTO {
    private List<BookMarkDTO> data;
    private int totalElements;
    private int totalPages;
    private int currentPage;
    private boolean isFirst;
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

    public BookMarksDTO(Page<BookMarkDTO> bookMarkPage){
        this.setData(bookMarkPage.getContent());
        this.setTotalElements((int) bookMarkPage.getTotalElements());
        this.setTotalPages(bookMarkPage.getTotalPages());
        this.setCurrentPage(bookMarkPage.getNumber()+1);
        this.setFirst(bookMarkPage.isFirst());
        this.setLast(bookMarkPage.isLast());
        this.setHasNext(bookMarkPage.hasNext());
        this.setHasPrevious(bookMarkPage.hasPrevious());
    }
}
