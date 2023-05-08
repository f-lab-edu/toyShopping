package com.iam.shopping.service;

import com.iam.shopping.domain.Item;
import com.iam.shopping.domain.UploadFile;
import com.iam.shopping.dto.ItemDTO;
import com.iam.shopping.mapper.ItemMapper;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemMapper itemMapper;

    public ItemService(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public List<Item> getItemList() {
        List<ItemDTO> items = itemMapper.selectItem();
        List<Item> itemList = items.stream()
                .map(itemDTO -> new Item(itemDTO.getItemId()
                        , itemDTO.getItemName()
                        , itemDTO.getPrice()
                        , itemDTO.getCategoryId()
                        , new UploadFile(itemDTO.getUploadFilename(), itemDTO.getOriginalFilename())))
                .collect(Collectors.toList());
        return itemList;
    }

    public void addItem(ItemDTO itemDTO) {
        Map<String, Object> itemMap = Map.of("itemName", itemDTO.getItemName()
                , "price", itemDTO.getPrice()
                , "categoryId", itemDTO.getCategoryId()
                , "uploadFilename", itemDTO.getUploadFilename()
                , "originalFilename", itemDTO.getOriginalFilename());
        itemMapper.insertItem(itemMap);
    }
}
