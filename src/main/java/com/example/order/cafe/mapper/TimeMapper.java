package com.example.order.cafe.mapper;

import com.example.order.cafe.domain.Time;
import com.example.order.cafe.dto.response.TimeResponse;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TimeMapper {
    TimeResponse toTimeResponse(Time time);
}