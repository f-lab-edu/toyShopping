package com.iam.shopping.mapper;

import com.iam.shopping.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<Category> categoryList(int paramNum);
    public void categoryInsert(Category category);
}
