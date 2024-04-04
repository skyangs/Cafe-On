package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeErrorMsg;

public class CafeMenu {

    private String menuName;
    private String explain;
    private int stock;
    private int price;

    private int MIN_NAME_LENGTH = 1;
    private int MIN_STOCK_LENGTH = 0;
    private int MIN_PRICE_LENGTH = 0;

    public CafeMenu(String menuName, String explain, int stock, int price){
        validation(menuName, stock, price);
        this.menuName = menuName;
        this.explain = explain;
        this.stock = stock;
        this.price = price;
    }

    private void validation(String menuName, int stock, int price) {
        validate_menuName(menuName);
        validate_stock(stock);
        validate_price(price);

    }

    private void validate_menuName(String menuName){
        if(menuName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(CafeErrorMsg.MENU_NAME_LENGTH_ERROR_MESSAGE.getValue());
        }
    }

    private void validate_stock(int stock){
        if(stock < MIN_STOCK_LENGTH){
            throw new IllegalArgumentException(CafeErrorMsg.STOCK_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    private void validate_price(int price){
        if(price < MIN_PRICE_LENGTH){
            throw new IllegalArgumentException(CafeErrorMsg.PRICE_UNDER_ZERO_ERROR_MESSAGE.getValue());
        }
    }

    public CafeMenu enrollCafeMenu(String menuName, String explain, int stock, int price){
        return new CafeMenu(menuName, explain, stock, price);
    }

    public void editCafeMenu(String menuName, String explain, int stock){
        this.menuName = menuName;
        this.explain = explain;
        this.stock =stock;
    }
}
