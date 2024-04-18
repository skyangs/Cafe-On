package com.example.order.cafe.service;


import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.OperationTimePerDayRequest;
import com.example.order.cafe.dto.response.BusinessHoursResponse;
import com.example.order.cafe.dto.response.OperationTimePerDayResponse;
import com.example.order.cafe.repository.BusinessHoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BusinessHoursService {

    private final BusinessHoursRepository businessHoursRepository;
    private final OperationTimePerDayService operationTimePerDayService;

    public BusinessHoursResponse getBusinessHours(long businessHoursId){

        BusinessHours businessHours = check_existBusinessHours(businessHoursId);

        List<OperationTimePerDayResponse> operationTimePerDayResponseList = businessHours.getOperationTimeList().stream()
                .map(operationTimePerDay -> {
                    return operationTimePerDayService.getOperationTimePerDay(operationTimePerDay.getId());
                })
                .toList();

        return new BusinessHoursResponse(operationTimePerDayResponseList);
    }

    @Transactional
    public BusinessHours registerBusinessHours(List<OperationTimePerDayRequest> operationTimePerDayRequestList){

        List<OperationTimePerDay> operationTimePerDayList =
                operationTimePerDayRequestList.stream()
                        .map(operationTimePerDayRequest -> {
                            return operationTimePerDayService.registerOperationTimePerDay(operationTimePerDayRequest.getDays(), operationTimePerDayRequest.getOperationTimeRequest());
                        })
                        .toList();

        BusinessHours businessHours = BusinessHours.of(operationTimePerDayList);

        return businessHoursRepository.save(businessHours);

    }


    public BusinessHours check_existBusinessHours(long id){

        return businessHoursRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }
}
