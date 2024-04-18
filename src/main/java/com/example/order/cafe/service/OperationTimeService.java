package com.example.order.cafe.service;

import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.Time;
import com.example.order.cafe.dto.request.TimeRequest;
import com.example.order.cafe.dto.response.OperationTimeResponse;
import com.example.order.cafe.dto.response.TimeResponse;
import com.example.order.cafe.repository.OperationTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OperationTimeService {

    private final OperationTimeRepository operationTimeRepository;
    private final TimeService timeService;

    public OperationTimeResponse getOperationTime(long operationTimeId){

        OperationTime operationTime = check_existOperationTime(operationTimeId);

        TimeResponse openTimeResponse = timeService.getTime(operationTime.getOpen().getId());
        TimeResponse closeTimeResponse = timeService.getTime(operationTime.getClose().getId());

        return new OperationTimeResponse(openTimeResponse, closeTimeResponse);
    }

    @Transactional
    public OperationTime registerOperationTime(TimeRequest open, TimeRequest close){

        Time registerOpenTime = timeService.registerTime(open.getHour(), open.getMinute());
        Time registerCloseTime = timeService.registerTime(close.getHour(), close.getMinute());

        OperationTime operationTime = OperationTime.of(registerOpenTime, registerCloseTime);

        return operationTimeRepository.save(operationTime);
    }

    @Transactional
    public OperationTime updateOperationTime(long operationTimeId, TimeRequest updateOpen, TimeRequest updateClose){

        OperationTime operationTime = check_existOperationTime(operationTimeId);

        Time updateOpenTime = timeService.updateTime(operationTime.getOpen().getId(), updateOpen.getHour(), updateOpen.getMinute());
        Time updateCloseTime = timeService.updateTime(operationTime.getClose().getId(), updateClose.getHour(), updateClose.getMinute());

        OperationTime updateOperationTime = OperationTime.of(updateOpenTime, updateCloseTime);

        return operationTimeRepository.save(updateOperationTime);

    }

    @Transactional
    public void deleteOperationTime(long OperationTimeId){

        OperationTime operationTime = check_existOperationTime(OperationTimeId);

        timeService.deleteTime(operationTime.getOpen().getId());
        timeService.deleteTime(operationTime.getClose().getId());

        operationTimeRepository.delete(operationTime);

    }

    public OperationTime check_existOperationTime(long OperationTimeId){
        return operationTimeRepository.findById(OperationTimeId)
                .orElseThrow(NoSuchElementException::new);
    }
}
