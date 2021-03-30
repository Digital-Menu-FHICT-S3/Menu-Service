package com.onlinemenu.menuservice.controller;

import com.onlinemenu.menuservice.entity.Category;
import com.onlinemenu.menuservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/menu/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.saveCategory(category);
    }

    @GetMapping("/delete/{id}")
    public Optional<Category> findCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("/{id}")
    public void deleteCategoryById(@PathVariable("id") Long categoryId){
        categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello from categories";
    }
}
