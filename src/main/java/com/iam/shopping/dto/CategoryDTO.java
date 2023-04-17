package com.iam.shopping.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;

@ApiOperation(value = "카테고리 데이터를 옮기기 위한 DTO 오브젝트", notes = "카테고리의 depth, categoryName, parentCategoryId, parentCategoryName 정보를 담아 전달한다.")
@Data
public class CategoryDTO {

    @ApiModelProperty(name = "depth", example = "3")
    @ApiParam(value = "카테고리분류", required = true)
    private int depth;

    @ApiModelProperty(name = "categoryName", example = "뷰티")
    @ApiParam(value = "카테고리명", required = true)
    private String categoryName;

    @ApiModelProperty(name = "parentCategoryId", example = "00003>00032>00037")
    @ApiParam(value = "부모카테고리ID", required = true)
    private String parentCategoryId;

    @ApiModelProperty(name = "parentCategoryName", example = "식품>채소>기타채소")
    @ApiParam(value = "부모카테고리명", required = true)
    private String parentCategoryName;
}
