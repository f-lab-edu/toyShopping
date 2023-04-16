package com.iam.shopping.dto;

public class CategoryDTO {
    private int depth;
    private String categoryId;
    private String categoryName;
    private String wholeCategoryId;
    private String wholeCategoryName;
    private String parentCategoryId;
    private String parentCategoryName;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getParentCategoryName() {
        return parentCategoryName;
    }
}
