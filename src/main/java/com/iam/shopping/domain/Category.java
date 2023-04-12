package com.iam.shopping.domain;

import lombok.Data;

@Data
public class Category {
    private String wholeCategoryId;
    private String wholeCategoryName;
    private String categoryId;
    private String categoryName;

    public Category() {

    }

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(String wholeCategoryId, String wholeCategoryName, String categoryId, String categoryName) {
        this.wholeCategoryId = wholeCategoryId;
        this.wholeCategoryName = wholeCategoryName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
