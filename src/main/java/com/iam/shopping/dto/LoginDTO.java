package com.iam.shopping.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @Schema(description = "아이디", defaultValue = "test7@naver.com", required = true, example = "test7@naver.com")
    @NotEmpty
    @Email
    String loginId;

    @Schema(description = "비밀번호", defaultValue = "1234", required = true, example = "1234")
    @NotEmpty
    String password;

    public LoginDTO(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
