package com.example.order.cafe.domain;

public class CafeMenu {

    private String menuName;
    private String explain;
    private int stock;

    private int MIN_NAME_LENGTH = 1;
    private final String NAME_LENGTH_ERROR_MESSAGE = "메뉴 이름은 1자 이상이여야 합니다.";

    public CafeMenu(String menuName, String explain, int stock){
        validation(menuName);
        this.menuName = menuName;
        this.explain = explain;
        this.stock =stock;
    }

    private void validation(String menuName) {
        if(menuName.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public CafeMenu enrollCafeMenu(String menuName, String explain, int stock){
        return new CafeMenu(menuName, explain, stock);
    }

    public void editCafeMenu(String menuName, String explain, int stock){
        this.menuName = menuName;
        this.explain = explain;
        this.stock =stock;
    }
}
