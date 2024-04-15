package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeMenuErrorMsg;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class CafeMenu {

    private final String menuName;
    private final List<TemperatureOption> temperatureOption;
    private final String explain;
    private final int stock;
    private final int price;

    private int MIN_NAME_LENGTH = 1;
    private int MIN_STOCK_LENGTH = 0;
    private int MIN_PRICE_LENGTH = 0;

    private CafeMenu(String menuName, List<TemperatureOption> temperatureOption, String explain, int stock, int price){
        validation(menuName, temperatureOption, stock, price);
        this.menuName = menuName;
        this.temperatureOption = new ArrayList<>(temperatureOption);
        this.explain = explain;
        this.stock = stock;
        this.price = price;
    }

    public static CafeMenu of(String menuName, List<TemperatureOption> temperatureOption, String explain, int stock, int price){
        return new CafeMenu(menuName, temperatureOption, explain, stock, price);
    }

    private void validation(String menuName, List<TemperatureOption> temperatureOption, int stock, int price) {
        validate_menuName(menuName);
        validate_temperatureOption(temperatureOption);
        validate_stock(stock);
        validate_price(price);

    }

    private void validate_menuName(String menuName){
        if(menuName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(CafeMenuErrorMsg.MENU_NAME_LENGTH_ERROR_MESSAGE.getValue());
        }
    }


    private void validate_temperatureOption(List<TemperatureOption> temperatureOption) {
        isTemperatureOptionNull(temperatureOption);
        temperatureOption_empty(temperatureOption);
    }

    private void isTemperatureOptionNull(List<TemperatureOption> temperatureOption){
        if(temperatureOption == null)
            throw new IllegalArgumentException(CafeMenuErrorMsg.TEMPERATURE_OPTION_NULL_ERROR_MESSAGE.getValue());
    }

    private void temperatureOption_empty(List<TemperatureOption> temperatureOption){
        if(temperatureOption.isEmpty()){
            throw new IllegalArgumentException(CafeMenuErrorMsg.TEMPERATURE_OPTION_EMPTY_ERROR_MESSAGE.getValue());
        }
    }


    private void validate_stock(int stock){
        if(stock < MIN_STOCK_LENGTH){
            throw new IllegalArgumentException(CafeMenuErrorMsg.STOCK_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    private void validate_price(int price){
        if(price < MIN_PRICE_LENGTH){
            throw new IllegalArgumentException(CafeMenuErrorMsg.PRICE_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    public boolean isMenuName(String menuName){
        return this.menuName.equals(menuName);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CafeMenu cafeMenu = (CafeMenu) o;
        return Objects.equals(menuName, cafeMenu.menuName) &&
                Objects.equals(temperatureOption, cafeMenu.temperatureOption) &&
                Objects.equals(price, cafeMenu.price)
                ;
    }

    public List<TemperatureOption> getTemperatureOption(){
        return List.copyOf(temperatureOption);
    }

}
