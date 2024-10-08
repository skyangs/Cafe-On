package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.CafeInfo;
import com.example.order.cafe.service.dto.request.CafeInfoCreateRequest;
import com.example.order.cafe.service.dto.request.CafeInfoUpdateRequest;
import com.example.order.cafe.service.dto.response.CafeInfoResponse;
import org.springframework.stereotype.Component;


@Component
public class CafeInfoMapper {

    public CafeInfoResponse toCafeInfoResponse(CafeInfo cafeInfo){
        return new CafeInfoResponse(cafeInfo.getName(),
                cafeInfo.getExplain(),
                cafeInfo.getContactNumber(),
                cafeInfo.getAddress());
    };

    public CafeInfo toCafeInfo(CafeInfoCreateRequest cafeInfoCreateRequest){
            if ( cafeInfoCreateRequest == null ) {
                return null;
            }

        return CafeInfo.of(cafeInfoCreateRequest.name(),
                cafeInfoCreateRequest.explain(),
                cafeInfoCreateRequest.contactNumber(),
                cafeInfoCreateRequest.address());
    }

    public CafeInfo toCafeInfo(CafeInfoUpdateRequest cafeInfoUpdateRequest){
        if ( cafeInfoUpdateRequest == null ) {
            return null;
        }

        return CafeInfo.of(cafeInfoUpdateRequest.name(),
                cafeInfoUpdateRequest.explain(),
                cafeInfoUpdateRequest.contactNumber(),
                cafeInfoUpdateRequest.address());
    }

}
