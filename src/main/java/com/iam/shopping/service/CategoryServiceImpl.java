package com.iam.shopping.service;

import com.iam.shopping.domain.Category;
import com.iam.shopping.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> categoryList(int paramNum) {
        List<Category> categories = categoryMapper.categoryList(paramNum);
        return categories;
    }

    @Override
    public void categoryInsert(Category category) {
        categoryMapper.categoryInsert(category);
    }
}
