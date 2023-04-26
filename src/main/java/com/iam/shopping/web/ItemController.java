package com.iam.shopping.web;

import com.iam.shopping.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

@RestController
@PropertySource("classpath:/application.properties")
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    // application이 실행 될 때 자동으로 setter 메서드 실행... 왜인지는 모르겠음;; -> 공부하고 따로 정리하기
    @Value("${file.dir}")
    public void setFilePath(String path) {
        logger.info("application file dir of path = {}", path);
        this.filePath = path;
    }

    @PostMapping("/test")
    public void test(@RequestPart(name = "item") Item item, @RequestPart(name = "file") MultipartFile multipartFile) {
        logger.info("itemName = {}", item.getItemName());
        logger.info("itemPrice = {}", item.getPrice());
        logger.info("multipartFile = {}", multipartFile.getOriginalFilename());
        logger.info("파일경로 = {}", getFilePath());
    }
}
