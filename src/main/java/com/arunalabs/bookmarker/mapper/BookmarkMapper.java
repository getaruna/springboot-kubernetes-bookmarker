package com.arunalabs.bookmarker.mapper;

import com.arunalabs.bookmarker.domain.BookMark;
import com.arunalabs.bookmarker.dto.BookMarkDTO;
import org.springframework.stereotype.Component;

@Component
public class BookmarkMapper {
    public BookMarkDTO toDTO(BookMark bookMark){
        BookMarkDTO dto = new BookMarkDTO();
        dto.setTitle(bookMark.getTitle());
        dto.setUrl(bookMark.getUrl());
        dto.setCreatedAt(bookMark.getCreatedAt());
        return dto;
    }
}
