package com.onlinemenu.menuservice.service;

import com.onlinemenu.menuservice.entity.Dish;
import com.onlinemenu.menuservice.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    public Dish saveDish(Dish dish) { return dishRepository.save(dish); }

    public Optional<Dish> findDishById(Long dishId) { return dishRepository.findById(dishId); }

    public void deleteDishById(Long dishId) { dishRepository.deleteById(dishId); }
}
