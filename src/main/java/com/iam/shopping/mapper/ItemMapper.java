package com.iam.shopping.mapper;

import com.iam.shopping.domain.Item;
import com.iam.shopping.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {
    public List<ItemDTO> selectItem();
    public void insertItem(Map<String, Object> itemMap);
}
