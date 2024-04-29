package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Days;
import com.example.order.cafe.dto.request.DaysRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DaysMapper {

    DaysMapper INSTANCE = Mappers.getMapper(DaysMapper.class);

    default Days toDays(DaysRequest daysRequest){
        if ( daysRequest == null ) {
            return null;
        }

        return Days.valueOf(String.valueOf(daysRequest.getDays()));

    }


}
