package com.iam.shopping.web;

import com.iam.shopping.domain.Category;
import com.iam.shopping.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @RequestMapping(value = "/{paramNum}", method = RequestMethod.GET)
//    public List<Category> category1stList(@PathVariable("paramNum") int dept) {
////        return categoryService.categoryList(dept);
//        return null;
//    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Category> categoryList(@RequestParam("depth") int depth
                                     , @RequestParam(value = "categoryId", required = false, defaultValue = "0") int categoryId) {
//        return categoryService.categoryList(dept);
        logger.info("category depth = {}", depth);
        logger.info("category categoryId = {}", categoryId);
        return null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void categoryInsert(@RequestBody Category category) {
        logger.info("category log = {}", category);
        categoryService.categoryInsert(category);
    }
}
