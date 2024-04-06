package com.example.order.cafe.domain;

import com.example.order.cafe.errorMsg.CafeInfoErrorMsg;

import java.util.Objects;

public class CafeInfo {
    private String name;
    private String explain;
    private String contactNumber;
    private String address;

    public static final String CONTACT_NUM_NUMBER_REG = "^\\d+$";
    public static final String CONTACT_NUM_FORMAT_REG = "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    private int MIN_NAME_LENGTH = 1;
    private int MIN_CONTACT_NUM_LENGTH = 9;
    private int MAX_CONTACT_NUM_LENGTH = 11;

    public CafeInfo(String name, String explain, String contactNumber, String address){
        validation(name, contactNumber);
        this.name = name;
        this.explain = explain;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    private void validation(String name, String contactNumber){
        check_name_length(name);

        check_contact_num_length(contactNumber);
        check_contact_num_only_number_regex(contactNumber);
        check_phone_num_format_regex(contactNumber);
    }

    public void check_name_length(String name){
        if(name.length() < MIN_NAME_LENGTH){
            throw new IllegalArgumentException(CafeInfoErrorMsg.CAFE_NAME_LENGTH_ERROR_MESSAGE.getValue());
        }
    }
    public void check_contact_num_length(String contactNumber){
        String contactNumAfterDeleteDash = replaceDashToSpace(contactNumber);

        if(contactNumAfterDeleteDash.length() < MIN_CONTACT_NUM_LENGTH || contactNumAfterDeleteDash.length() > MAX_CONTACT_NUM_LENGTH){
            throw new IllegalArgumentException(CafeInfoErrorMsg.CAFE_CONTACT_NUM_LENGTH_ERROR_MESSAGE.getValue());
        }

    }

    public void check_contact_num_only_number_regex(String contactNumber){
        String phoneNumAfterDeleteDash = replaceDashToSpace(contactNumber);

        if(!phoneNumAfterDeleteDash.matches(CONTACT_NUM_NUMBER_REG)){
            throw new IllegalArgumentException(CafeInfoErrorMsg.CAFE_CONTACT_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE.getValue());

        }
    }

    public void check_phone_num_format_regex(String contactNumber){

        if(!contactNumber.matches(CONTACT_NUM_FORMAT_REG)){
            throw new IllegalArgumentException(CafeInfoErrorMsg.CAFE_CONTACT_NUM_FORMAT_REGEX_ERROR_MESSAGE.getValue());

        }

    }

    public String replaceDashToSpace(String contactNumber){
        return contactNumber.replaceAll("-", "");
    }


    public boolean isMyAddress(String address){
        return  this.address.equals(address);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CafeInfo cafeInfo = (CafeInfo) o;
        return Objects.equals(name, cafeInfo.name) &&
                Objects.equals(contactNumber, cafeInfo.contactNumber) &&
                Objects.equals(address, cafeInfo.address);
    }

}
