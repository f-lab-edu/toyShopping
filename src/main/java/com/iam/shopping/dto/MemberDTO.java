package com.iam.shopping.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiOperation(value = "회원정보를 옮기기 위한 DTO 오브젝트", notes = "회원ID를 전달한다.")
@Data
public class MemberDTO {
    @ApiModelProperty(name = "id", example = "test@naver.com")
    @ApiParam(value = "회원ID", required = true)
    private String id;
}
