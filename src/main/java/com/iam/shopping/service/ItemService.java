package com.iam.shopping.service;

import com.iam.shopping.dto.ItemDTO;
import com.iam.shopping.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemService {
    private final ItemMapper itemMapper;

    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public void addItem(ItemDTO itemDTO) {
        Map<String, Object> itemMap = Map.of("itemName", itemDTO.getItemName()
                , "price", itemDTO.getPrice()
                , "categoryId", itemDTO.getCategoryId()
                , "uploadFilename", itemDTO.getUploadFile().getUploadFilename()
                , "originalFilename", itemDTO.getUploadFile().getOriginalFilename());
        itemMapper.insertItem(itemMap);
    }
}
