package com.example.order.member.domain;

import com.example.order.member.errorMsg.MemberErrorMsg;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class Member {

    @Getter
    private String memberId;
    private String password;
    private AuthType authType;
    private String phoneNum;

    public static final String MEMBER_ID_REG = "^(?=.*[a-zA-Z])(?=.*\\d).+$";
    public static final String PHONE_NUM_FORMAT_REG = "^\\d{3}-\\d{4}-\\d{4}$";
    public static final String PHONE_NUM_NUMBER_REG = "^\\d+$";

    private final int MIN_ID_LENGTH = 4;
    private final int MAX_ID_LENGTH = 10;
    private final int MIN_PASSWORD_LENGTH = 8;
    private final int MAX_PASSWORD_LENGTH = 15;
    private final int PHONE_NUM_LENGTH = 11;

    private Member(String memberId, String password, AuthType authType, String phoneNum){
        validation(memberId, password, phoneNum);
        this.memberId = memberId;
        this.password = password;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

    public static Member of(String memberId, String password, AuthType authType, String phoneNum){
        return new Member(memberId, password, authType, phoneNum);
    }

    public void validation(String memberId, String password, String phoneNum){
        check_id_length(memberId);
        check_id_regex(memberId);

        check_password_length(password);

        check_phone_num_length(phoneNum);
        check_phone_num_only_number_regex(phoneNum);
        check_phone_num_format_regex(phoneNum);
    }

    public void check_id_length(String memberId){

        if(memberId.length() < MIN_ID_LENGTH || memberId.length() > MAX_ID_LENGTH){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_ID_LENGTH_ERROR_MESSAGE.getValue());
        }

    }

    public void check_id_regex(String memberId){

        if(!memberId.matches(MEMBER_ID_REG)){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_ID_REGEX_ERROR_MESSAGE.getValue());
        }
    }

    public void check_password_length(String password){

        if(password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE.getValue());

        }
    }

    public void check_phone_num_length(String phoneNum){
        String phoneNumAfterDeleteDash = removeHyphens(phoneNum);

        if(phoneNumAfterDeleteDash.length() != PHONE_NUM_LENGTH){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE.getValue());
        }

    }

    public void check_phone_num_only_number_regex(String phoneNum){
        String phoneNumAfterDeleteDash = removeHyphens(phoneNum);

        if(!phoneNumAfterDeleteDash.matches(PHONE_NUM_NUMBER_REG)){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_PHONE_NUM_ONLY_NUMBER_REGEX_ERROR_MESSAGE.getValue());

        }

    }

    public void check_phone_num_format_regex(String phoneNum){

        if(!phoneNum.matches(PHONE_NUM_FORMAT_REG)){
            throw new IllegalArgumentException(MemberErrorMsg.MEMBER_PHONE_NUM_FORMAT_REGEX_ERROR_MESSAGE.getValue());

        }

    }

    public String removeHyphens(String phoneNum){
        return phoneNum.replaceAll("-", "");
    }

}
