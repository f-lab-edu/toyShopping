package com.iam.shopping.service;

import com.iam.shopping.domain.Category;
import com.iam.shopping.dto.CategoryDTO;
import com.iam.shopping.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public List<Category> categoryList(CategoryDTO categoryDTO) {
        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("depth", categoryDTO.getDepth());
        categoryMap.put("parentCategoryId", categoryDTO.getParentCategoryId());
        return categoryMapper.getCategoryList(categoryMap);
    }

    public void categoryInsert(CategoryDTO categoryDTO) {
        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("depth", categoryDTO.getDepth());
        categoryMap.put("categoryName", categoryDTO.getCategoryName());
        categoryMap.put("parentCategoryId", categoryDTO.getParentCategoryId());
        categoryMap.put("parentCategoryName", categoryDTO.getParentCategoryName());
        categoryMapper.insertCategory(categoryMap);
    }
}
