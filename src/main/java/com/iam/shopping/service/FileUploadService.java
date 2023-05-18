package com.iam.shopping.service;

import com.iam.shopping.domain.UploadFile;
import com.iam.shopping.exception.FileExtensionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
//@PropertySource("classpath:/application.properties")
public class FileUploadService {
    @Value("${file.path}")
    private String filePath;

    public String getFileFullPath(String fileName) {
        return filePath + fileName;
    }

    public String createUploadFileName(String originalFilename) {
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 파일확장자

        if (!ext.contains("png") && !ext.contains("jpg")) {
            throw new FileExtensionException("파일 확장자는 PNG, JPG만 등록가능합니다.");
        }

        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public UploadFile uploadFile(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename(); // 원본파일명
        String uploadFilename = createUploadFileName(originalFilename); // uuid 붙은 파일명

        // uploadFilename + property file path
        try {
            multipartFile.transferTo(new File(getFileFullPath(uploadFilename))); // 파일저장
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new UploadFile(uploadFilename, originalFilename);
    }
}
