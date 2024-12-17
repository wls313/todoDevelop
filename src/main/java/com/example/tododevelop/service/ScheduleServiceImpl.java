package com.example.tododevelop.service;

import com.example.tododevelop.dto.ScheduleResponseDto;
import com.example.tododevelop.entity.Schedule;
import com.example.tododevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto save(String title, String contents, String username) {

        Schedule schedule = new Schedule(title,contents,username);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(), schedule.getContents(), schedule.getUsername());
    }
}
