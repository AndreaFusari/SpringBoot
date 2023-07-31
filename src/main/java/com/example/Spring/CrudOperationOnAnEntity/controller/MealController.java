package com.example.Spring.CrudOperationOnAnEntity.controller;

import com.example.Spring.CrudOperationOnAnEntity.entity.Meal;
import com.example.Spring.CrudOperationOnAnEntity.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;
    @PostMapping
    public ResponseEntity<?> createMeal(Meal meal){
        mealService.createMeal(meal);
        return ResponseEntity.ok("Meal added");
    }
    @GetMapping
    public ResponseEntity<Meal> getMeal (Long id){
        return ResponseEntity.ok(mealService.getMeal(id));
    }
    @PutMapping
    public ResponseEntity<String> updateMeal(Meal meal){
        mealService.updateMeal(meal);
        return ResponseEntity.ok("Meal updated");
    }
    @DeleteMapping
    public ResponseEntity<String>deleteMeal(Long id){
        mealService.deleteMeal(id);
        return ResponseEntity.ok("Meal deleted");
    }
    @GetMapping(value="/winterMeals")
    public ResponseEntity<List<Meal>> getWinterMeals(){
        return ResponseEntity.ok(mealService.getWinterMeals());
    }

}
