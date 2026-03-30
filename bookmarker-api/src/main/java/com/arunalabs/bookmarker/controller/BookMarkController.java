package com.arunalabs.bookmarker.controller;

import com.arunalabs.bookmarker.dto.BookMarksDTO;
import com.arunalabs.bookmarker.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookMarkController {
    private final BookMarkService bookMarkService;

    @GetMapping//this maps the get request to the getBookMarks method
    public BookMarksDTO getBookMarks(@RequestParam(name="page",defaultValue = "10") int page ){
        return bookMarkService.getAllBookmarks(page);
    }
}
