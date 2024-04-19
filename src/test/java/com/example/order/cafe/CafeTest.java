package com.example.order.cafe;

import com.example.order.cafe.domain.*;
import com.example.order.cafe.errorMsg.CafeErrorMsg;
import com.example.order.cafe.fixture.BusinessHoursFixture;
import com.example.order.cafe.fixture.CafeInfoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CafeTest {

    @DisplayName("생성 : 정상 테스트")
    @Test
    public void create(){

        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();

        Cafe 카페 = Cafe.of(카페프로필, 운영시간);

        assertEquals(카페.getCafeInfo(), 카페프로필);
        assertEquals(카페.getBusinessHours(), 운영시간);

    }

    @DisplayName("생성 예외 : 카페프로필 null")
    @Test
    public void create_error_cafeInfo_null() {

        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();

        CafeInfo 카페프로필_널 = null;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cafe.of(카페프로필_널,운영시간))
                .withMessage(CafeErrorMsg.CAFE_INFO_NULL_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 예외 : 운영시간 null")
    @Test
    public void create_error_businessHours_null() {

       BusinessHours 운영시간_널 = null;

        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cafe.of(카페프로필,운영시간_널))
                .withMessage(CafeErrorMsg.BUSINESS_HOURS_NULL_ERROR_MESSAGE.getValue());
    }

    @DisplayName("생성 : 수정")
    @Test
    public void update() {

        BusinessHours 운영시간 = BusinessHoursFixture.운영시간_전체기본생성();
        CafeInfo 카페프로필 = CafeInfoFixture.카페프로필_기본생성();
        Cafe 카페 = Cafe.of(카페프로필, 운영시간);

        OperationTimePerDay 변경_월요일 =  OperationTimePerDay.of(Days.MONDAY, BusinessHoursFixture.주말_운영시간);
        OperationTimePerDay 변경_화요일 =  OperationTimePerDay.of(Days.TUESDAY, BusinessHoursFixture.주말_운영시간);
        OperationTimePerDay 변경_수요일 =  OperationTimePerDay.of(Days.WEDNESDAY, BusinessHoursFixture.주말_운영시간);
        OperationTimePerDay 변경_목요일 =  OperationTimePerDay.of(Days.THURSDAY, BusinessHoursFixture.주말_운영시간);
        OperationTimePerDay 변경_금요일 =  OperationTimePerDay.of(Days.FRIDAY, BusinessHoursFixture.주말_운영시간);
        OperationTimePerDay 변경_토요일 =  OperationTimePerDay.of(Days.SATURDAY, BusinessHoursFixture.평일_운영시간);
        OperationTimePerDay 변경_일요일 =  OperationTimePerDay.of(Days.SUNDAY, BusinessHoursFixture.평일_운영시간);

        List<OperationTimePerDay> 변경_운영시간_리스트 = new ArrayList<>();

        변경_운영시간_리스트.add(변경_월요일);
        변경_운영시간_리스트.add(변경_화요일);
        변경_운영시간_리스트.add(변경_수요일);
        변경_운영시간_리스트.add(변경_목요일);
        변경_운영시간_리스트.add(변경_금요일);
        변경_운영시간_리스트.add(변경_토요일);
        변경_운영시간_리스트.add(변경_일요일);

        BusinessHours 변경_운영시간 = BusinessHours.of(변경_운영시간_리스트);

        String 변경_카페명 = "카페명";
        String 변경_설명 = "저희카페는 부산에 위치해있습니다.";
        String 변경_연락처  = "031-222-2222";
        String 변경_주소=  "부산광역시 해운대";

        CafeInfo 변경_카페프로필 = CafeInfo.of(변경_카페명, 변경_설명, 변경_연락처, 변경_주소);

        Cafe 변경_카페 = 카페.updateCafe(변경_카페프로필, 변경_운영시간);

        assertThat(변경_카페.getCafeInfo()).isEqualTo(변경_카페프로필);
        assertThat(변경_카페.getBusinessHours()).isEqualTo(변경_운영시간);
    }

}
