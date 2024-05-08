package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.OperationTimePerDayRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperationTimePerDayMapper {

    OperationTimePerDayMapper INSTANCE = Mappers.getMapper(OperationTimePerDayMapper.class);

    @Mapping(target = "businessHoursId", ignore = true)
    default OperationTimePerDay toOperationTimePerDay(OperationTimePerDayRequest operationTimePerDayRequest){
        if ( operationTimePerDayRequest == null ) {
            return null;
        }

        Days days = DaysMapper.INSTANCE.toDays(operationTimePerDayRequest.getDays());
        OperationTime operationTime = OperationTimeMapper.INSTANCE.toOperationTime(operationTimePerDayRequest.getOperationTime());

        return OperationTimePerDay.of(days, operationTime);
    }
}
