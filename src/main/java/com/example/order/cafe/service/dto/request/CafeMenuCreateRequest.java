package com.example.order.cafe.service.dto.request;


import com.example.order.cafe.domain.MenuCategory;
import com.example.order.cafe.domain.TemperatureOption;
import com.example.order.cafe.domain.TemperatureType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CafeMenuCreateRequest(
        @NotNull Long cafeId,
        @NotBlank String menuName,
        @NotNull @NotEmpty List<TemperatureType> temperatureTypeList,
        @Valid MenuCategory menuCategory,
        @NotBlank String explain,
        @NotNull int stock,
        @NotNull int price

){}
