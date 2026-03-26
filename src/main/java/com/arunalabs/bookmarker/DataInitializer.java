package com.arunalabs.bookmarker;
import com.arunalabs.bookmarker.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookMarkRepository bookMarkRepository;

    @Override
    public void run(String... args) throws Exception{
        /*bookMarkRepository.save(new com.arunalabs.bookmarker.domain.BookMark(null,"Google","https://www.google.com", Instant.now()));
        bookMarkRepository.save(new com.arunalabs.bookmarker.domain.BookMark(null,"Facebook","https://www.facebook.com",Instant.now()));
        bookMarkRepository.save(new com.arunalabs.bookmarker.domain.BookMark(null,"Twitter","https://www.twitter.com",Instant.now()));
        bookMarkRepository.save(new com.arunalabs.bookmarker.domain.BookMark(null,"LinkedIn","https://www.linkedin.com",Instant.now()));
        bookMarkRepository.save(new com.arunalabs.bookmarker.domain.BookMark(null,"GitHub","https://www.github.com",Instant.now()));
        */
    }
}