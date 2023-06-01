package com.iam.shopping.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @Schema(description = "아이디", defaultValue = "test7@naver.com", required = true, example = "test7@naver.com")
    @NotEmpty(message = "Email은 비어 있을 수 없습니다.")
    @Email
    String loginId;

    @Schema(description = "비밀번호", defaultValue = "1234", required = true, example = "1234")
    @NotEmpty(message = "Password는 비어 있을 수 없습니다.")
    String password;

}
