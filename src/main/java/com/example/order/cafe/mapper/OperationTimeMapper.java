package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.OperationTime;
import com.example.order.cafe.domain.Time;
import com.example.order.cafe.dto.request.OperationTimeRequest;
import com.example.order.cafe.dto.request.TimeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OperationTimeMapper {

    OperationTimeMapper INSTANCE = Mappers.getMapper(OperationTimeMapper.class);
    default OperationTime toOperationTime(OperationTimeRequest operationTimeRequest){
            if ( operationTimeRequest == null ) {
                return null;
            }
        TimeRequest open = operationTimeRequest.getOpen();
        TimeRequest close = operationTimeRequest.getClose();

        return OperationTime.of(toTime(open), toTime(close));
    }


    default Time toTime(TimeRequest timeRequest){
        if ( timeRequest == null ) {
            return null;
        }

        return Time.of(timeRequest.getHour(), timeRequest.getMinute());

    }
}
