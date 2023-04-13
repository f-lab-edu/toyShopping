package com.iam.shopping.web;

import com.iam.shopping.domain.Category;
import com.iam.shopping.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/{depth}", method = RequestMethod.GET)
    public List<Category> categoryList(@PathVariable("depth") int depth) {
        Map<String, Integer> categoryMap = new HashMap<>();
        categoryMap.put("depth", depth);
        return categoryService.getCategoryList(categoryMap);
    }

    @RequestMapping(value = "/{depth}/{categoryId}", method = RequestMethod.GET)
    public List<Category> category2ndList(@PathVariable("depth") int depth, @PathVariable("categoryId") int categoryId) {
        Map<String, Integer> categoryMap = new HashMap<>();
        categoryMap.put("categoryParent", categoryId);
        return categoryService.getCategoryList(categoryMap);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void categoryInsert(@RequestBody Category category) {
        logger.info("category log = {}", category);
        categoryService.categoryInsert(category);
    }
}
