package com.iam.shopping.mapper;

import com.iam.shopping.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {

    private static Map<String, Category> store = new HashMap<>();

    @Override
    public void save(Category category) {
        store.put(category.getCategoryId(), category);
    }
}
