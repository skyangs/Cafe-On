package com.example.order.cafe.service;

import com.example.order.cafe.domain.Time;
import com.example.order.cafe.dto.response.TimeResponse;
import com.example.order.cafe.mapper.TimeMapper;
import com.example.order.cafe.repository.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TimeService {

    private final TimeRepository timeRepository;
    private final TimeMapper timeMapper;

    public TimeResponse getTime(long timeId){

        Time time = timeRepository.findById(timeId)
                .orElseThrow(NoSuchElementException::new);

        return timeMapper.toTimeResponse(time);
    }

    @Transactional
    public Time registerTime(int hour, int minute){

        Time time = Time.of(hour, minute);

        return timeRepository.save(time);
    }

    @Transactional
    public Time updateTime(long timeId, int hour, int minute){

        Time time = check_existTime(timeId);

        Time updateTime = Time.of(hour, minute);

        return timeRepository.save(updateTime);

    }

    @Transactional
    public void deleteTime(long timeId){

        Time time = check_existTime(timeId);

        timeRepository.delete(time);

    }

    public Time check_existTime(long timeId){
        return timeRepository.findById(timeId)
                .orElseThrow(NoSuchElementException::new);
    }
}
