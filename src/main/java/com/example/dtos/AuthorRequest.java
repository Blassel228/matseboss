package com.example.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthorRequest {

    @NotBlank
    private String name;

    public AuthorRequest() {}

    public AuthorRequest(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}