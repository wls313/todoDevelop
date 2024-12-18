package com.example.tododevelop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotBlank
    private final String email;

    // 사용자가 입력한 비밀번호
    @NotNull
    private final String password;
}
