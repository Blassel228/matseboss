package com.example.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(ZoneOffset.UTC);

    @ManyToOne(optional = false)
    private Author author;

    public Note(String title, String content, LocalDateTime createdAt, Author author) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author;
    }
}
