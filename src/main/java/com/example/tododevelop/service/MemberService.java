package com.example.tododevelop.service;

import com.example.tododevelop.dto.MemberResponseDto;

import java.util.List;

public interface MemberService {
    MemberResponseDto signUp(String username, String email, String password);

    List<MemberResponseDto> findAll();
}
