package com.iam.shopping.domain;

import lombok.Data;

@Data
public class Category {
    private int depth;
    private int categoryId;
    private String categoryName;
    private String categoryParent;
}
