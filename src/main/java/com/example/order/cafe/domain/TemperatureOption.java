package com.example.order.cafe.domain;

import com.example.order.global.common.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class TemperatureOption extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafeMenuId")
    private final CafeMenu cafeMenu;

    @Enumerated(EnumType.STRING)
    private final TemperatureType temperatureType;

    private TemperatureOption(CafeMenu cafeMenu, TemperatureType temperatureType){
        this.cafeMenu = cafeMenu;
        this.temperatureType = temperatureType;
    }

    public static TemperatureOption of(CafeMenu cafeMenu, TemperatureType temperatureType){
        return new TemperatureOption(cafeMenu, temperatureType);
    }

}
