package com.arunalabs.bookmarker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name="bookmarks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {
    @Id //designates this field as the primary key of the table
    @SequenceGenerator(name="bm_id_seq_gen", sequenceName="bm_id_seq", initialValue = 1, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bm_id_seq_gen")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    @Column(name = "created_at", insertable = false, updatable = false)
    private Instant createdAt;
}
