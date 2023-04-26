package com.iam.shopping.service;

import com.iam.shopping.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@PropertySource("classpath:/application.properties")
public class FileUploadService {
    @Value("${file.path}")
    private String filePath;

    public String getFileFullPath(String fileName) {
        return filePath + fileName;
    }

    public String createUploadFileName(String originalFilename) {
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 파일확장자
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    public UploadFile uploadFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String uploadFilename = createUploadFileName(originalFilename);
        // 해당 경로에 파일저장
        multipartFile.transferTo(new File(getFileFullPath(uploadFilename)));
        return new UploadFile(uploadFilename, originalFilename);
    }
}