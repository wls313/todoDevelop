package com.example.tododevelop.controller;

import com.example.tododevelop.dto.MemberRequestDto;
import com.example.tododevelop.dto.MemberResponseDto;
import com.example.tododevelop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> save(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto memberResponseDto = memberService.signUp(requestDto.getUsername(),requestDto.getEmail(),requestDto.getPassword());

        return new ResponseEntity<>(memberResponseDto,HttpStatus.CREATED);
    }
}
