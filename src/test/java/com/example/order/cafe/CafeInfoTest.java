package com.example.order.cafe;

import com.example.order.cafe.domain.CafeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CafeInfoTest {

    String NAME_LENGTH_ERROR_MESSAGE = "카페명은 1자 이상이여야 합니다.";

    @DisplayName("생성 테스트 : 카페명 1글자 이상")
    @Test
    public void create_error_name() {

        String 빈_카페명 = "";
        String 카페설명 = "저희카페는 강남에 위치해있습니다.";
        String 연락처 = "021111111";
        String 주소 = "서울시 강남구 1010동";

        Exception 예외_영업시간 = assertThrows(IllegalArgumentException.class,
                () -> new CafeInfo(빈_카페명, 카페설명, 연락처, 주소));

        assertThat(예외_영업시간.getMessage()).isEqualTo(NAME_LENGTH_ERROR_MESSAGE);

    }

}
