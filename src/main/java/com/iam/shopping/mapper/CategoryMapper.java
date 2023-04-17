package com.iam.shopping.mapper;

import com.iam.shopping.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {

    public List<Category> getCategoryList(Map<String, Object> categoryMap);

    public void insertCategory(Map<String, Object> categoryMap);
}
