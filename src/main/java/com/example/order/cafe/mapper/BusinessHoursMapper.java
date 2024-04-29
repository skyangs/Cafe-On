package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.BusinessHoursRequest;
import com.example.order.cafe.dto.request.OperationTimePerDayRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;


@Mapper(componentModel = "spring")
public interface BusinessHoursMapper {

    BusinessHoursMapper INSTANCE = Mappers.getMapper(BusinessHoursMapper.class);

    default BusinessHours toBusinessHours(BusinessHoursRequest businessHoursRequest){

        List<OperationTimePerDay> operationTimeList =
                toOperationTimePerDayList( businessHoursRequest.getOperationTimePerDayList() );

        return BusinessHours.of( operationTimeList );
    }

    default List<OperationTimePerDay> toOperationTimePerDayList(List<OperationTimePerDayRequest> operationTimePerDayRequestList) {
        if ( operationTimePerDayRequestList == null ) {
            return null;
        }

        List<OperationTimePerDay> list = new ArrayList<OperationTimePerDay>( operationTimePerDayRequestList.size() );
        for ( OperationTimePerDayRequest operationTimePerDayRequest : operationTimePerDayRequestList ) {
            list.add( OperationTimePerDayMapper.INSTANCE.toOperationTimePerDay(operationTimePerDayRequest) );
        }

        return list;
    }
}
