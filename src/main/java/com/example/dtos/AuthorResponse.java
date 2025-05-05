package com.example.dtos;

import lombok.Getter;

import java.util.UUID;

@Getter
public class AuthorResponse {

    private Long id;
    private String name;

    public AuthorResponse() {}

    public AuthorResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}