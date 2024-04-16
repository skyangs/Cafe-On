package com.example.order.cafe.service;

import com.example.order.cafe.CafeTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;

public class CafeInfoServiceTest {

    @InjectMocks
    private CafeInfoService cafeInfoService;

//    @Mock
//    private CafeRepository cafeRepository;


    //내rk 테스트하고자하는 대상을 명확히 한다
    //의존성은 mocking
    //비회원 주문
    //인증코드를 만들어서 인증코드 인증 을 한 사람은 주문이 가능

    //

    // cafeInfo 잘 받는지(정상테스트)
    // exception 호출되는지
    // println 호출되나?

    //mockito


    //jpa repository -
    //domain entity로

    //service
//    @DisplayName("getCafeInfo 테스트")
//    @Test
//    public void getCafeInfoTest(){
//        //given
//
//        when(cafeRepository.getCafeInfo(any()).thenReturn("cafeInfo");
//        //when
//        cafeInfoService.getCafeInfo(1);
//
//        Assertions.assertThatThrownBy(() -> cafeInfoService.getCafeInfo(1))
//                .isInstanceOf(RuntimeException.class);
//        //then
//    }
}
