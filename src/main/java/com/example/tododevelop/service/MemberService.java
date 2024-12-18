package com.example.tododevelop.service;

import com.example.tododevelop.dto.MemberResponseDto;

public interface MemberService {
    MemberResponseDto signUp(String username, String email, String password);
}
