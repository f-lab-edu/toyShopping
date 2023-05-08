package com.iam.shopping.web;

import com.iam.shopping.domain.Item;
import com.iam.shopping.domain.UploadFile;
import com.iam.shopping.dto.ItemDTO;
import com.iam.shopping.service.FileUploadService;
import com.iam.shopping.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Tag(name = "item", description = "상품 등록, 조회 API")
@RestController
@PropertySource("classpath:/application.properties")
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FileUploadService fileUploadService;
    private final ItemService itemService;

    public ItemController(FileUploadService fileUploadService, ItemService itemService) {
        this.fileUploadService = fileUploadService;
        this.itemService = itemService;
    }

    @Tag(name = "item")
    @ApiOperation(value = "이미지경로조회", notes = "파일이름으로 이미지가 저장된 경로를 찾는다.")
    @RequestMapping(value = "/images/{filename}", method = RequestMethod.GET)
    public Resource getFilePath(@PathVariable String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileUploadService.getFileFullPath(filename));
    }

    @Tag(name = "item")
    @ApiOperation(value = "상품조회", notes = "상품조회")
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public List<Item> getItemList() {
        List<Item> itemList = itemService.getItemList();
        return itemList;
    }

    @Tag(name = "item")
    @ApiOperation(value = "상품등록", notes = "상품등록")
    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public void saveItem(@RequestPart(name = "item") ItemDTO itemDTO, @RequestPart(name = "file") MultipartFile multipartFile) throws IOException {
        // 이미지파일저장
        UploadFile uploadFile = fileUploadService.uploadFile(multipartFile);
        itemDTO.setUploadFilename(uploadFile.getUploadFilename());
        itemDTO.setOriginalFilename(uploadFile.getOriginalFilename());
        itemService.addItem(itemDTO);
    }
}
