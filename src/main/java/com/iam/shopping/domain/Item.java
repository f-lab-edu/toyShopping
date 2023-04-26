package com.iam.shopping.domain;

import lombok.Data;

@Data
public class Item {
    private String itemId;
    private String itemName;
    private int price;
    private String categoryId;
    private String uploadFilename;
    private String originalFilename;
}
