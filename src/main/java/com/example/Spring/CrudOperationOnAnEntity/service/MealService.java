package com.example.Spring.CrudOperationOnAnEntity.service;

import com.example.Spring.CrudOperationOnAnEntity.entity.Meal;
import com.example.Spring.CrudOperationOnAnEntity.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;
    public void addMeal(Meal meal){
        mealRepository.save(meal);
    }
    public Meal getMeal(Long id){
        return mealRepository.findById(id).orElse(null);
    }

    public void updateMeal(Meal meal){
        mealRepository.save(meal);
    }
    public void deleteMeal(Long id){
        mealRepository.deleteById(id);
    }
}
