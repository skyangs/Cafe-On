package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.service.dto.request.DaysRequest;
import com.example.order.cafe.service.dto.request.DaysUpdateRequest;
import org.springframework.stereotype.Component;


@Component
public class DaysMapper {

    public Days toDays(DaysRequest daysRequest){
        if ( daysRequest == null ) {
            return null;
        }

        return Days.valueOf(String.valueOf(daysRequest.days()));

    }

    public Days toDays(DaysUpdateRequest daysUpdateRequest){
        if ( daysUpdateRequest == null ) {
            return null;
        }

        return Days.valueOf(String.valueOf(daysUpdateRequest.days()));

    }


}
