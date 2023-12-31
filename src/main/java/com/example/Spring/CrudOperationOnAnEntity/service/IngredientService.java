package com.example.Spring.CrudOperationOnAnEntity.service;

import com.example.Spring.CrudOperationOnAnEntity.entity.Ingredient;
import com.example.Spring.CrudOperationOnAnEntity.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;
    public void createIngredient(Ingredient ingredient){ingredientRepository.save(ingredient);
    }
    public Ingredient getIngredient(Long id){
        return ingredientRepository.findById(id).orElse(null);
    }
    public void updateIngredient(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }
    public void deleteIngredient(Long id){
        ingredientRepository.deleteById(id);
    }

}
