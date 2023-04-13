package com.iam.shopping.mapper;

import com.iam.shopping.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper {

    // parameter를 2개 이상 받을 때 map으로 받지 않으면 MyBatis에서 오류발생
    public List<Category> getCategoryList(Map<String, Integer> categoryMap);

    public void categoryInsert(Category category);
}
