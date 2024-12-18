package com.example.tododevelop.service;

import com.example.tododevelop.dto.ScheduleResponseDto;
import com.example.tododevelop.entity.Schedule;
import com.example.tododevelop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String title, String contents, String username) {

        Schedule schedule = new Schedule(title,contents,username);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(),schedule.getTitle(), schedule.getContents(), schedule.getUsername());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);


        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents(), schedule.getUsername());
    }

    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(schedule);
    }

    @Transactional
    public void updateSchedule(Long id, String Title, String Contents) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        schedule.updateSchedule(Title,Contents);
    }

}
