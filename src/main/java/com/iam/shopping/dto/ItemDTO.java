package com.iam.shopping.dto;

import com.iam.shopping.domain.UploadFile;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@ApiOperation(value = "상품정보 및 이미지파일을 옮기기 위한 DTO", notes = "상품명, 상품가격, 카테고리, 업로드파일의 정보를 담아 전달한다.")
@Data
public class ItemDTO {
    @Schema(description = "상품명", defaultValue = "상품A", required = true, example = "상품A")
    private String itemName;

    @Schema(description = "상품가격", defaultValue = "10000", required = true, example = "10000")
    private int price;

    @Schema(description = "카테고리ID", defaultValue = "00012", required = true, example = "00012")
    private String categoryId;

    private UploadFile uploadFile;
}
