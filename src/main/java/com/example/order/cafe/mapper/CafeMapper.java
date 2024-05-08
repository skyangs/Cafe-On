package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.dto.request.*;
import com.example.order.cafe.dto.response.CafeResponse;
import com.example.order.cafe.dto.response.OperationTimePerDayResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CafeMapper {
    CafeMapper INSTANCE = Mappers.getMapper(CafeMapper.class);

    CafeResponse toCafeResponse(Cafe cafe);

    List<OperationTimePerDayResponse> toOperationTimePerDayList(List<OperationTimePerDay> operationTimePerDayList);

    default Cafe toCafe(CafeInfoCreateRequest cafeInfoCreateRequest, BusinessHoursRequest businessHoursRequest) {
        if ( cafeInfoCreateRequest == null && businessHoursRequest == null) {
            return null;
        }

        CafeInfo cafeInfo = CafeInfoMapper.INSTANCE.toCafeInfo(cafeInfoCreateRequest);
        BusinessHours businessHours = BusinessHoursMapper.INSTANCE.toBusinessHours(businessHoursRequest);

        return Cafe.of(cafeInfo, businessHours);
    }

    default CafeInfo mapCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest) {
        return CafeMapper.INSTANCE.toCafeInfo(cafeInfoCreateRequest);
    }

    CafeInfo toCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest);

    Cafe toCafe(CafeUpdateRequest cafeUpdateRequest);

}





