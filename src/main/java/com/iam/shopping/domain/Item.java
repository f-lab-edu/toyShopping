package com.iam.shopping.domain;

import lombok.Data;
import org.springframework.core.io.Resource;

@Data
public class Item {
    private String itemId;
    private String itemName;
    private int price;
    private String categoryId;
    private UploadFile uploadFile;

    public Item(String itemId, String itemName, int price, String categoryId, UploadFile uploadFile) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.categoryId = categoryId;
        this.uploadFile = uploadFile;
    }
}
