package com.example.tododevelop.service;

import com.example.tododevelop.dto.MemberResponseDto;
import com.example.tododevelop.dto.ScheduleResponseDto;
import com.example.tododevelop.entity.Member;
import com.example.tododevelop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto signUp(String username, String email, String password) {
        Member member = new Member(username,email,password);

        Member savedmember = memberRepository.save(member);

        return new MemberResponseDto(savedmember.getId(), savedmember.getUsername(), savedmember.getEmail());
    }

    @Override
    public List<MemberResponseDto> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto::toDto)
                .toList();
    }

    public MemberResponseDto findById(Long id) {
        Member member = memberRepository.findByIdOrElseThrow(id);

        return new MemberResponseDto(member.getId(), member.getUsername(), member.getEmail());
    }
}
