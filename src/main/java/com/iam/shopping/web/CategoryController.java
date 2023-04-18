package com.iam.shopping.web;

import com.iam.shopping.domain.Category;
import com.iam.shopping.dto.CategoryDTO;
import com.iam.shopping.service.CategoryService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Category", description = "Category 등록 API")
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "카테고리리스트조회", notes = "카테고리리스트조회")
    @ApiImplicitParam(
            name = "depth"
            , value = "카테고리 분류 Level"
            , required = true
            , dataType = "int"
            , paramType = "path"
            , defaultValue = "1"
    )
    @RequestMapping(value = "/{depth}", method = RequestMethod.GET)
    public List<Category> categoryList(@PathVariable("depth") int depth) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDepth(depth);
        return categoryService.categoryList(categoryDTO);
    }

    @ApiOperation(value = "카테고리상세조회", notes = "카테고리 depth와 부모카테고리Id 정보를 가져와 중분류, 소분류 카테고리를 조회한다.")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "depth"
                    , value = "카테고리 분류 Level"
                    , required = true
                    , dataType = "int"
                    , paramType = "path"
                    , defaultValue = ""
            ),
            @ApiImplicitParam(
                    name = "parentCategoryId"
                    , value = "카테고리 부모 ID"
                    , required = true
                    , dataType = "String"
                    , paramType = "path"
                    , defaultValue = ""
            )
    })
    @RequestMapping(value = "/{depth}/{parentCategoryId}", method = RequestMethod.GET)
    public List<Category> category2ndList(@PathVariable("depth") int depth, @PathVariable("parentCategoryId") String parentCategoryId) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setDepth(depth);
        categoryDTO.setParentCategoryId(parentCategoryId);
        return categoryService.categoryList(categoryDTO);
    }

    @ApiOperation(value = "카테고리추가")
    @RequestMapping(method = RequestMethod.POST)
    public void categoryInsert(@RequestBody CategoryDTO categoryDTO) {
        logger.info("category log = {}", categoryDTO);
        categoryService.categoryInsert(categoryDTO);
    }

}
