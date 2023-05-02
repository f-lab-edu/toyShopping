package com.iam.shopping.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ItemMapper {
    public void insertItem(Map<String, Object> itemMap);
}
