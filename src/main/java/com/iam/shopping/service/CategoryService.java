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
        Map<String, Object> categoryMap = Map.of("depth", categoryDTO.getDepth()
                , "parentCategoryId", categoryDTO.getParentCategoryId() == null ? "" : categoryDTO.getParentCategoryId()
        );
        return categoryMapper.getCategoryList(categoryMap);
    }

    public void categoryInsert(CategoryDTO categoryDTO) {
        Map<String, Object> categoryMap = Map.of("depth", categoryDTO.getDepth()
                , "categoryName", categoryDTO.getCategoryName()
                , "parentCategoryId", categoryDTO.getParentCategoryId()
                , "parentCategoryName", categoryDTO.getParentCategoryName()
        );
        categoryMapper.insertCategory(categoryMap);
    }
}
