package com.iam.shopping.domain;

import lombok.Data;

@Data
public class UploadFile {
    private String uploadFilename;
    private String originalFilename;

    public UploadFile(String uploadFilename, String originalFilename) {
        this.uploadFilename = uploadFilename;
        this.originalFilename = originalFilename;
    }
}
