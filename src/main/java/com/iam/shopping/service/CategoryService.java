package com.iam.shopping.service;

import com.iam.shopping.domain.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    public List<Category> getCategoryList(Map<String, Integer> categoryMap);

    public void categoryInsert(Category category);
}
