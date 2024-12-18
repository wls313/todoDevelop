package com.example.tododevelop.dto;

import com.example.tododevelop.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
            @Valid @RequestBody LoginRequestDto request,
            HttpServletResponse response // 쿠키값 세팅에 필요
    ) {
        // 로그인 유저 조회
        LoginResponseDto responseDto = userService.login(request.getEmail(), request.getPassword());

        if (responseDto.getId() == null) {
            // 로그인 실패 예외처리
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // 로그인 성공 처리
        // 쿠키 생성, Value는 문자열로 변환하여야 한다.
        Cookie cookie = new Cookie("userId", String.valueOf(responseDto.getId()));

        // 쿠키에 값 세팅 (expire 시간을 주지 않으면 세션쿠키가 됨, 브라우저 종료시 로그아웃)
        // Response Set-Cookie: userId=1 형태로 전달된다.
        response.addCookie(cookie);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
