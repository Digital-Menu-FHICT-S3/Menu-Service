package com.onlinemenu.menuservice.controller;

import com.onlinemenu.menuservice.entity.Category;
import com.onlinemenu.menuservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/createCategories")
    public List<Category> saveCategories(@RequestBody List<Category> categories){
        return categoryService.saveCategories(categories);
    }
    @GetMapping("{name}")
    public Category getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
    @GetMapping("{id}")
    public Optional<Category> findCategoryById(@PathVariable("id") Long categoryId){
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable("id") Long categoryId){
        categoryService.deleteCategoryById(categoryId);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories(){
        return categoryService.GetAllCategories();
    }

    @PutMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
}
