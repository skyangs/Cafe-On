package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Cafe;
import com.example.order.cafe.domain.OperationTimePerDay;
import com.example.order.cafe.dto.request.CafeCreateRequest;
import com.example.order.cafe.dto.request.CafeUpdateRequest;
import com.example.order.cafe.dto.response.CafeResponse;
import com.example.order.cafe.dto.response.OperationTimePerDayResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CafeMapper {
    CafeMapper INSTANCE = Mappers.getMapper(CafeMapper.class);

    @Mapping(source = "businessHours", target = "businessHours")
    CafeResponse toCafeResponse(Cafe cafe);

    List<OperationTimePerDayResponse> toOperationTimePerDayList(List<OperationTimePerDay> operationTimePerDayList);

    Cafe toCafe(CafeCreateRequest cafeCreateRequest);
    Cafe toCafe(CafeUpdateRequest cafeUpdateRequest);

}





