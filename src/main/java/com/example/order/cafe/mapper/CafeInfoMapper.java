package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.dto.request.CafeInfoCreateRequest;
import com.example.order.cafe.dto.request.CafeInfoUpdateRequest;
import com.example.order.cafe.dto.response.CafeInfoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CafeInfoMapper {

    CafeInfoMapper INSTANCE = Mappers.getMapper(CafeInfoMapper.class);

    CafeInfoResponse toCafeInfoResponse(CafeInfo cafeInfo);

    default CafeInfo toCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest){
            if ( cafeInfoCreateRequest == null ) {
                return null;
            }

        return CafeInfo.of(cafeInfoCreateRequest.getName(), cafeInfoCreateRequest.getExplain(), cafeInfoCreateRequest.getContactNumber(), cafeInfoCreateRequest.getAddress());
    }

    default CafeInfo toCafeInfo(CafeInfoUpdateRequest cafeInfoUpdateRequest){
        if ( cafeInfoUpdateRequest == null ) {
            return null;
        }

        return CafeInfo.of(cafeInfoUpdateRequest.getName(), cafeInfoUpdateRequest.getExplain(), cafeInfoUpdateRequest.getContactNumber(), cafeInfoUpdateRequest.getAddress());
    }

}
