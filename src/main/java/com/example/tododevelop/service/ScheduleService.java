package com.example.tododevelop.service;

import com.example.tododevelop.dto.ScheduleResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto save(String title, String contents, String username);

    List<ScheduleResponseDto> findAll();

    ScheduleResponseDto findById(Long id);

    void delete(Long id);

    void updateSchedule(Long id, String title, String contents);
}
