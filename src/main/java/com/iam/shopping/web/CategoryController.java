package com.iam.shopping.web;

import com.iam.shopping.domain.Category;
import com.iam.shopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public void addCategoryPOST(@RequestBody Category category) {
        System.out.println(category);
        System.out.println(category.getCategoryId());
    }
}
