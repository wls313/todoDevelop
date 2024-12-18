package com.example.tododevelop.dto;

import lombok.Getter;

@Getter
public class MemberRequestDto {
    private final String username;
    private final String email;
    private final String password;

    public MemberRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
