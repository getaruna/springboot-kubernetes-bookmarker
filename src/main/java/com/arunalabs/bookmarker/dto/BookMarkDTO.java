package com.arunalabs.bookmarker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookMarkDTO {
    private String title;
    private String url;
    private Instant createdAt;
}
