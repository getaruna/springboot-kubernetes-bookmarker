package com.arunalabs.bookmarker.service;

import com.arunalabs.bookmarker.dto.BookMarkDTO;
import com.arunalabs.bookmarker.dto.BookMarksDTO;
import com.arunalabs.bookmarker.mapper.BookmarkMapper;
import com.arunalabs.bookmarker.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {
    private final BookMarkRepository bookMarkRepository;
    private final BookmarkMapper bookmarkMapper;
    @Transactional(readOnly = true)
    public BookMarksDTO getAllBookmarks(int page) {
        int pageNo = page < 1 ? 0 : page - 1;//as jpa has 0 indexed page numbering
        Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookMarkDTO> bookmarkPage = bookMarkRepository.findBookmarks(pageable);
        return new BookMarksDTO(bookmarkPage);
    }
}