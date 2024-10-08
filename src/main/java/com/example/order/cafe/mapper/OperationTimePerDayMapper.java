package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.service.dto.request.OperationTimePerDayRequest;
import com.example.order.cafe.service.dto.request.OperationTimePerDayUpdateRequest;
import com.example.order.cafe.service.dto.response.OperationTimePerDayResponse;
import com.example.order.cafe.service.dto.response.OperationTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class OperationTimePerDayMapper {

    private final DaysMapper daysMapper;
    private final OperationTimeMapper operationTimeMapper;

    public OperationTimePerDay toOperationTimePerDay(OperationTimePerDayRequest operationTimePerDayRequest){
        if ( operationTimePerDayRequest == null ) {
            return null;
        }

        Days days = daysMapper.toDays(operationTimePerDayRequest.days());
        OperationTime operationTime = operationTimeMapper.toOperationTime(operationTimePerDayRequest.operationTime());

        return OperationTimePerDay.of(days, operationTime);
    }

    public OperationTimePerDay toOperationTimePerDay(OperationTimePerDayUpdateRequest operationTimePerDayUpdateRequest){
        if ( operationTimePerDayUpdateRequest == null ) {
            return null;
        }

        Days days = daysMapper.toDays(operationTimePerDayUpdateRequest.days());
        OperationTime operationTime = operationTimeMapper.toOperationTime(operationTimePerDayUpdateRequest.operationTime());

        return OperationTimePerDay.of(days, operationTime);
    }

    public OperationTimePerDayResponse toOperationTimePerDayResponse(OperationTimePerDay operationTimePerDay){
        if ( operationTimePerDay == null ) {
            return null;
        }

        OperationTimeResponse operationTimeResponse = operationTimeMapper.toOperationTimeResponse(operationTimePerDay.getOperationTime());

        return new OperationTimePerDayResponse (operationTimePerDay.getDays(), operationTimeResponse);
    }
}
