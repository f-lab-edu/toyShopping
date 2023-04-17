package com.iam.shopping.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private int depth;
    private String categoryName;
    private String parentCategoryId;
    private String parentCategoryName;
}
