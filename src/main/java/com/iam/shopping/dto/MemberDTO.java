package com.iam.shopping.dto;

import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiOperation(value = "회원정보를 옮기기 위한 DTO 오브젝트", notes = "회원 아이디, 비밀번호, 이름, 전화번로를 전달한다.")
@Data
public class MemberDTO {
    @Schema(description = "아이디", defaultValue = "test7@naver.com", required = true, example = "test7@naver.com")
    @NotEmpty
    @Email
    private String id;

    @Schema(description = "비밀번호", defaultValue = "1234", required = true, example = "1234")
    @NotEmpty
    private String pass;

    @Schema(description = "이름", defaultValue = "홍길동", required = true, example = "홍길동")
    @NotEmpty
    private String name;

    @Schema(description = "전화번호", defaultValue = "01012345678", required = true, example = "01012345678")
    @NotEmpty
    private String phone;

    @Schema(description = "테스트여부", defaultValue = "true", required = true, example = "true")
    private boolean isTest = false;
}
