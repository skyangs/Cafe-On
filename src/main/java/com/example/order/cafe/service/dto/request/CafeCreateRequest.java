package com.example.order.cafe.service.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class CafeCreateRequest {
    @NotNull
    private final CafeInfoCreateRequest cafeInfo;
    @NotNull
    private final BusinessHoursRequest businessHours;

    public CafeCreateRequest(CafeInfoCreateRequest cafeInfo, BusinessHoursRequest businessHours){
        this.cafeInfo = cafeInfo;
        this.businessHours = businessHours;
    }

}
