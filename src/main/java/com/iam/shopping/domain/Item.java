package com.iam.shopping.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String itemId;
    private String itemName;
    private int price;
    private String categoryId;
    private UploadFile uploadFile;

}
