package com.example.Spring.CrudOperationOnAnEntity.controller;

import com.example.Spring.CrudOperationOnAnEntity.entity.Ingredient;
import com.example.Spring.CrudOperationOnAnEntity.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @PostMapping
    public ResponseEntity<?> createIngredient(Ingredient ingredient){
        ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok("Ingredient added");
    }
    @GetMapping
    public ResponseEntity<Ingredient> getIngredient(Long id){
        return ResponseEntity.ok(ingredientService.getIngredient(id));
    }
    @PutMapping
    public ResponseEntity<String> updateIngredient(Ingredient ingredient){
        ingredientService.updateIngredient(ingredient);
        return ResponseEntity.ok("Ingredient updated");
    }
    @DeleteMapping
    public ResponseEntity<String>deleteIngredient(Long id){
        ingredientService.deleteIngredient(id);
        return ResponseEntity.ok("Ingredient deleted");
    }
}
