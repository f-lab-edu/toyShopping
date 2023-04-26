package com.iam.shopping.web;

import com.iam.shopping.domain.UploadFile;
import com.iam.shopping.dto.ItemDTO;
import com.iam.shopping.service.FileUploadService;
import com.iam.shopping.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@PropertySource("classpath:/application.properties")
@RequestMapping("/item")
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FileUploadService fileUploadService;
    private final ItemService itemService;

    public ItemController(FileUploadService fileUploadService, ItemService itemService) {
        this.fileUploadService = fileUploadService;
        this.itemService = itemService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveItem(@RequestPart(name = "item") ItemDTO itemDTO, @RequestPart(name = "file") MultipartFile multipartFile) throws IOException {
        // 파일저장
        UploadFile uploadFile = fileUploadService.uploadFile(multipartFile);
        itemDTO.setUploadFile(uploadFile);

        logger.info("itemName = {}", itemDTO.getItemName());
        logger.info("itemPrice = {}", itemDTO.getPrice());
        logger.info("itemCategoryId = {}", itemDTO.getCategoryId());
        logger.info("uploadFile = {}", itemDTO.getUploadFile().getUploadFilename());
        logger.info("uploadFile = {}", itemDTO.getUploadFile().getOriginalFilename());

        itemService.addItem(itemDTO);
    }
}
