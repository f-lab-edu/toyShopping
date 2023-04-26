package com.iam.shopping.dto;

import com.iam.shopping.domain.UploadFile;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ItemDTO {
    private String itemName;
    private int price;
    private String categoryId;
    private UploadFile uploadFile;
}
