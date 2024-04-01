package com.example.order.member.domain;

public class Member {

    private String memberId;
    private String password;
    private AuthType authType;
    private String phoneNum;

    private final String MEMBER_ID_LENGTH_ERROR_MESSAGE = "아이디는 4-10자여야 합니다.";
    private final String MEMBER_ID_REGEX_ERROR_MESSAGE = "아이디는 영문과 숫자로 이루어져야 합니다.";
    private final String MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE = "비밀번호는 8-15자여야 합니다.";
    private final String MEMBER_PHONE_NUM_REGEX_ERROR_MESSAGE = "휴대폰번호는 숫자로만 이루어져야 합니다.";
    private final String MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE = "휴대폰번호는 11자리여야 합니다.";
    private final int MIN_ID_LENGTH = 4;
    private final int MAX_ID_LENGTH = 10;
    private final int MIN_PASSWORD_LENGTH = 8;
    private final int MAX_PASSWORD_LENGTH = 15;
    private final int PHONE_NUM_LENGTH = 11;

    public Member(String memberId, String password, AuthType authType, String phoneNum){
        validation(memberId, password, phoneNum);
        this.memberId = memberId;
        this.password = password;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

    public void validation(String memberId, String password, String phoneNum){
        check_id_length(memberId);
        check_id_regex(memberId);

        check_password_length(password);

        check_phone_num_length(phoneNum);
        check_phone_num_regex(phoneNum);
    }

    public void check_id_length(String memberId){

        if(memberId.length() < MIN_ID_LENGTH || memberId.length() > MAX_ID_LENGTH){
            throw new IllegalArgumentException(MEMBER_ID_LENGTH_ERROR_MESSAGE);
        }

    }

    public void check_id_regex(String memberId){
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d).+$";

        boolean check_id = memberId.matches(regex);

        if(!check_id){
            throw new IllegalArgumentException(MEMBER_ID_REGEX_ERROR_MESSAGE);
        }
    }

    public void check_password_length(String password){

        if(password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH){
            throw new IllegalArgumentException(MEMBER_PASSWORD_LENGTH_ERROR_MESSAGE);

        }
    }

    public void check_phone_num_length(String phoneNum){

        if(phoneNum.length() != PHONE_NUM_LENGTH){
            throw new IllegalArgumentException(MEMBER_PHONE_NUM_LENGTH_ERROR_MESSAGE);
        }

    }

    public void check_phone_num_regex(String phoneNum){
        String regex = "^\\d{11}$";

        boolean check_phone_num = phoneNum.matches(regex);

        if(!check_phone_num){
            throw new IllegalArgumentException(MEMBER_PHONE_NUM_REGEX_ERROR_MESSAGE);

        }

    }
}
