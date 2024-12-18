package com.example.tododevelop.dto;

import lombok.Getter;

@Getter
public class MemberPasswordRequestDto {

    private final String oldPassword;

    private final String newPassword;

    public MemberPasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
