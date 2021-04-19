package com.onlinemenu.menuservice.controller;

import com.onlinemenu.menuservice.entity.Dish;
import com.onlinemenu.menuservice.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/menu/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping("/create")
    public Dish saveDish(@RequestBody Dish dish){
        return dishService.saveDish(dish);
    }

    @GetMapping("/delete/{id}")
    public Optional<Dish> findDishById(@PathVariable("id") Long dishId){
        return dishService.findDishById(dishId);
    }

    @GetMapping("/{id}")
    public void deleteDishById(@PathVariable("id") Long dishId){
        dishService.deleteDishById(dishId);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello from dishes";
    }
}
