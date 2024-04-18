package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.dto.response.CafeInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CafeInfoMapper {

    CafeInfoResponse toCafeInfoResponse(CafeInfo cafeInfo);

}
