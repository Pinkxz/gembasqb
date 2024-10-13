package com.web_project.gembasqb.dtos;

public record LoginResponseDTO(String token) {

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
