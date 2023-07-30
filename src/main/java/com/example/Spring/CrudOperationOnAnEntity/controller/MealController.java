package com.example.Spring.CrudOperationOnAnEntity.controller;

import com.example.Spring.CrudOperationOnAnEntity.controller.dto.MealDto;
import com.example.Spring.CrudOperationOnAnEntity.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;
    @PostMapping
    public ResponseEntity<?> addMeal(MealDto mealDto){
        mealService.addMeal(mealDto);
        return ResponseEntity.ok("Meal added");
    }

}
