package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.dto.response.CafeInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CafeInfoMapper {

    CafeInfoMapper INSTANCE = Mappers.getMapper(CafeInfoMapper.class);

    CafeInfoResponse toCafeInfoResponse(CafeInfo cafeInfo);

}
