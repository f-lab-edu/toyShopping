package com.iam.shopping.web;

import com.iam.shopping.domain.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/test")
    public void test(@RequestPart(name = "item") Item item, @RequestPart(name = "file") MultipartFile multipartFile) {
        logger.info("itemName = {}", item.getItemName());
        logger.info("itemPrice = {}", item.getPrice());
        logger.info("multipartFile = {}", multipartFile.getOriginalFilename());
    }
}
