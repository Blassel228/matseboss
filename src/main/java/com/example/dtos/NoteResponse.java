package com.example.dtos;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoteResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long authorId;

    public NoteResponse() {}

    public NoteResponse(Long id, String title, String content, LocalDateTime createdAt, Long authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.authorId = authorId;
    }

}