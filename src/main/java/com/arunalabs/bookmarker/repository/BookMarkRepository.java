package com.arunalabs.bookmarker.repository;

import com.arunalabs.bookmarker.domain.BookMark;
import com.arunalabs.bookmarker.dto.BookMarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookMarkRepository extends JpaRepository<BookMark,Long> {
    @Query("select new com.arunalabs.bookmarker.dto.BookMarkDTO(b.title,b.url,b.createdAt) from com.arunalabs.bookmarker.domain.BookMark b")
    Page<BookMarkDTO> findBookmarks(Pageable pageable);
}
