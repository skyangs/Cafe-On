package com.example.order.member.dto.request;

import com.example.order.member.domain.AuthType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@Getter
public class UpdateMemberInfoRequest {

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Size(min = 8, max = 15, message = "비밀번호는 8-15자여야 합니다.")
    private final String password;
    @NotNull(message = "권한은 필수 입력 값 입니다.")
    private final AuthType authType;
    @NotBlank(message = "휴대폰 번호는 필수 입력 값 입니다.")
    @Size(min = 9, max = 11, message = "휴대폰 번호는 9-11자여야 합니다.")
    @Pattern(regexp = "^\\d+$", message = "휴대폰 번호는 숫자로 이루어져야 합니다.")
    private final String phoneNum;

    public UpdateMemberInfoRequest(String password, AuthType authType, String phoneNum){
        this.password = password;
        this.authType = authType;
        this.phoneNum = phoneNum;
    }

}
