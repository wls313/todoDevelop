package com.example.tododevelop.service;

import com.example.tododevelop.dto.LoginResponseDto;
import com.example.tododevelop.entity.Member;
import com.example.tododevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public LoginResponseDto login(String email, String password) {
        // 입력받은 userName, password와 일치하는 Database 조회
        Optional<Member> memberOptional = userRepository.findByEmail(email);

        if (memberOptional.isEmpty()) {
            throw new IllegalArgumentException("email 또는 비밀번호가 잘못됐습니다");
        }

        Member member = memberOptional.get();

        return new LoginResponseDto(member.getId());
    }

    public Optional<Member> findById(Long id) {

        return userRepository.findById(id);
    }
}