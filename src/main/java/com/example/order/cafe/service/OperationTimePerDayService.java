package com.example.order.cafe.service;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.DaysRequest;
import com.example.order.cafe.dto.request.OperationTimeRequest;
import com.example.order.cafe.dto.response.OperationTimePerDayResponse;
import com.example.order.cafe.dto.response.OperationTimeResponse;
import com.example.order.cafe.repository.OperationTimePerDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class OperationTimePerDayService {

    private final OperationTimePerDayRepository operationTimePerDayRepository;
    private final OperationTimeService operationTimeService;

    public OperationTimePerDayResponse getOperationTimePerDay(long operationTimePerDayId){

        OperationTimePerDay operationTimePerDay = check_existOperationTimePerDay(operationTimePerDayId);

        OperationTimeResponse operationTimeResponse = operationTimeService.getOperationTime(operationTimePerDay.getId());

        return new OperationTimePerDayResponse(operationTimePerDay.getDays().getValue(), operationTimeResponse);
    }

    @Transactional
    public OperationTimePerDay registerOperationTimePerDay(DaysRequest days, OperationTimeRequest operationTimeRequest){

        Days dayOfWeek = days.getDayOfWeek();
        OperationTime operationTime = operationTimeService.registerOperationTime(operationTimeRequest.getOpen(), operationTimeRequest.getClose());

        OperationTimePerDay operationTimePerDay = OperationTimePerDay.of(dayOfWeek, operationTime);

        return operationTimePerDayRepository.save(operationTimePerDay);
    }

    @Transactional
    public OperationTimePerDay updateOperationTimePerDay(long operationTimePerDayId, OperationTimeRequest operationTimeRequest){

        OperationTimePerDay operationTimePerDay = check_existOperationTimePerDay(operationTimePerDayId);

        OperationTime updateOperationTime = operationTimeService.updateOperationTime(operationTimePerDay.getId(), operationTimeRequest.getOpen(), operationTimeRequest.getClose());

        OperationTimePerDay updateOperationTimePerDay = OperationTimePerDay.of(operationTimePerDay.getDays(), updateOperationTime);

        return operationTimePerDayRepository.save(updateOperationTimePerDay);

    }

    @Transactional
    public void deleteOperationTimePerDay(long operationTimePerDayId){

        OperationTimePerDay operationTimePerDay = check_existOperationTimePerDay(operationTimePerDayId);

        operationTimeService.deleteOperationTime(operationTimePerDay.getOperationTime().getId());

        operationTimePerDayRepository.delete(operationTimePerDay);

    }

    public OperationTimePerDay check_existOperationTimePerDay(long OperationTimePerDayId){
        return operationTimePerDayRepository.findById(OperationTimePerDayId)
                .orElseThrow(NoSuchElementException::new);
    }

}
