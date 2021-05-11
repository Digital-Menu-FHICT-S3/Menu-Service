package com.onlinemenu.menuservice.service;

import com.onlinemenu.menuservice.entity.Category;
import com.onlinemenu.menuservice.entity.Dish;
import com.onlinemenu.menuservice.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Dish> getAllDishes() {return dishRepository.findAll();}

    public List<Dish> getAllDishesInShoppingCart(List<Long> dishIds) { return dishRepository.findAllById(dishIds); }

    public Dish saveDish(Dish dish) { return dishRepository.save(dish); }

    public Optional<Dish> findDishById(Long dishId) { return dishRepository.findById(dishId); }

    public void deleteDishById(Long dishId) { dishRepository.deleteById(dishId); }

    public Dish updateDish(Dish dish) { return dishRepository.save(dish);}

    public List<Dish> findDishesByCategoryId(Long categoryId) {
        return dishRepository.findByCategoryId(categoryId);
    }

    public List<Dish> findDishesByCategoryName(String name) {
        Category category = restTemplate.getForObject("http://localhost:9191/menu/categories/name/" + name, Category.class);
        System.out.println(category);
        System.out.println("something");
        return dishRepository.findByCategoryId(category.getCategoryId());
    }
}
