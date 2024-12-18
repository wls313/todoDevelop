package com.example.tododevelop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class LoginResponseDto {
    private final Long id;

    public LoginResponseDto(Long id) {
        this.id = id;
    }
}