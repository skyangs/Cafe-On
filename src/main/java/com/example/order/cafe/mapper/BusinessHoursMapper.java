package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.BusinessHours;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.BusinessHoursRequest;
import com.example.order.cafe.dto.request.BusinessHoursUpdateRequest;
import com.example.order.cafe.dto.request.OperationTimePerDayRequest;
import com.example.order.cafe.dto.request.OperationTimePerDayUpdateRequest;
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

        return BusinessHours.of(operationTimeList);
    }

    default List<OperationTimePerDay> toOperationTimePerDayList(List<OperationTimePerDayRequest> operationTimePerDayRequestList) {
        if ( operationTimePerDayRequestList == null ) {
            return null;
        }

        List<OperationTimePerDay> operationTimePerDayList = new ArrayList<>( operationTimePerDayRequestList.size() );

        for ( OperationTimePerDayRequest operationTimePerDayRequest : operationTimePerDayRequestList ) {
            OperationTimePerDay operationTimePerDay = OperationTimePerDayMapper.INSTANCE.toOperationTimePerDay(operationTimePerDayRequest);
            operationTimePerDayList.add( operationTimePerDay );
        }

        return operationTimePerDayList;
    }


//    default BusinessHours toBusinessHours(BusinessHoursUpdateRequest businessHoursUpdateRequest){
//
//        List<OperationTimePerDay> operationTimeList =
//                toOperationTimePerDayList( businessHoursUpdateRequest.getOperationTimePerDayList() );
//
//        return BusinessHours.of(operationTimeList);
//    }
//
//    default List<OperationTimePerDay> toOperationTimePerDayList(List<OperationTimePerDayUpdateRequest> operationTimePerDayUpdateRequestList) {
//        if ( operationTimePerDayUpdateRequestList == null ) {
//            return null;
//        }
//
//        List<OperationTimePerDay> operationTimePerDayList = new ArrayList<>( operationTimePerDayUpdateRequestList.size() );
//
//        for ( OperationTimePerDayUpdateRequest operationTimePerDayUpdateRequest : operationTimePerDayUpdateRequestList ) {
//            OperationTimePerDay operationTimePerDay = OperationTimePerDayMapper.INSTANCE.toOperationTimePerDay(operationTimePerDayUpdateRequest);
//            operationTimePerDayList.add( operationTimePerDay );
//        }
//
//        return operationTimePerDayList;
//    }
}
