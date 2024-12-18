package com.example.tododevelop.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    // 유저 식별자
    private final Long id;
    // 유저 이름
    private final String name;

    public UserResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}