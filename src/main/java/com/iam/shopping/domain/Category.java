package com.iam.shopping.domain;

import lombok.Data;

@Data
public class Category {
    private int depth;
    private String categoryId;
    private String categoryName;
    private String wholeCategoryId;
    private String wholeCategoryName;
}
