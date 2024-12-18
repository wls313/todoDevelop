package com.example.tododevelop.service;

import com.example.tododevelop.dto.MemberResponseDto;
import com.example.tododevelop.entity.Member;
import com.example.tododevelop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto signUp(String username, String email, String password) {
        Member member = new Member(username,email,password);

        Member savedmember = memberRepository.save(member);

        return new MemberResponseDto(savedmember.getId(), savedmember.getUsername(), savedmember.getEmail());
    }
}
