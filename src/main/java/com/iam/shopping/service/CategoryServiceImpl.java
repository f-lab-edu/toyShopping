package com.iam.shopping.service;

import com.iam.shopping.domain.Category;
import com.iam.shopping.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList(Map<String, Integer> categoryMap) {
        return categoryMapper.getCategoryList(categoryMap);
    }

    @Override
    public void categoryInsert(Category category) {
        categoryMapper.categoryInsert(category);
    }
}
