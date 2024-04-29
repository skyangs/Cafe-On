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

    @Mapping(source = "businessHours", target = "businessHours")
    CafeResponse toCafeResponse(Cafe cafe);

    List<OperationTimePerDayResponse> toOperationTimePerDayList(List<OperationTimePerDay> operationTimePerDayList);

    default Cafe toCafe(CafeCreateRequest cafeCreateRequest) {
        if ( cafeCreateRequest == null) {
            return null;
        }

        CafeInfo cafeInfo = CafeInfoMapper.INSTANCE.toCafeInfo(cafeCreateRequest.getCafeInfo());
        BusinessHours businessHours = BusinessHoursMapper.INSTANCE.toBusinessHours(cafeCreateRequest.getBusinessHours());

        return Cafe.of(cafeInfo, businessHours);
    }

    default CafeInfo mapCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest) {
        return CafeMapper.INSTANCE.toCafeInfo(cafeInfoCreateRequest);
    }

    CafeInfo toCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest);

    Cafe toCafe(CafeUpdateRequest cafeUpdateRequest);

}





