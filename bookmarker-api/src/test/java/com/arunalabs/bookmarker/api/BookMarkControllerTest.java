package com.arunalabs.bookmarker.api;

import com.arunalabs.bookmarker.domain.BookMark;
import com.arunalabs.bookmarker.repository.BookMarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {"spring.datasource.url=jdbc:tc:postgresql:14-alpine:///testdb"})//meaning, don't look at application.properties for datasource url, instead use this one for testing. This will create a temporary postgres database in a docker container for testing -purposes.
public class BookMarkControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    BookMarkRepository bookMarkRepository;

    private List<BookMark> bookMarks;

    @BeforeEach
    void setUp() {
        bookMarkRepository.deleteAllInBatch();
        bookMarks = List.of(
                new BookMark(null,"Google","https://www.google.com", null),
                new BookMark(null,"Facebook","https://www.facebook.com",null),
                new BookMark(null,"Twitter","https://www.twitter.com",null),
                new BookMark(null,"LinkedIn","https://www.linkedin.com",null),
                new BookMark(null,"GitHub","https://www.github.com",null),
                new BookMark(null,"StackOverflow","https://www.stackoverflow.com",null),
                new BookMark(null,"Reddit","https://www.reddit.com",null),
                new BookMark(null,"YouTube","https://www.youtube.com",null),
                new BookMark(null,"Instagram","https://www.instagram.com",null),
                new BookMark(null,"Netflix","https://www.netflix.com",null),
                new BookMark(null,"Amazon","https://www.amazon.com",null),
                new BookMark(null,"Wikipedia","https://www.wikipedia.org",null));
        bookMarkRepository.saveAll(bookMarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,12,2,false",
            "2,12,2,true"
    })
    void shouldGetBookMarks(int pageNo,int totalElements, int totalPages, boolean isLastPage) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(totalElements))
                .andExpect(jsonPath("$.totalPages").value(totalPages))
                .andExpect(jsonPath("$.last").value(isLastPage));

        //.andExpect(jsonPath("$.bookMarks").isArray());
    }

    @Test
    void shouldGetBookMarks_RealCall() throws Exception {
        ResponseEntity<Map> response = restTemplate.getForEntity("/api/bookmarks", Map.class);

        // 2. Check the Status Code (Real HTTP response)
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // 3. Check the Body
        Map<String, Object> body = response.getBody();
        assertThat(body.get("totalElements")).isEqualTo(12);
    }
}
