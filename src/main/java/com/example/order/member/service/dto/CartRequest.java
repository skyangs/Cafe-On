package com.example.order.member.service.dto;

import lombok.Getter;

@Getter
public class CartRequest {
    private long cafeId;
    private long menuId;
//    private List<Option> optionList;
    private int amount;
}
