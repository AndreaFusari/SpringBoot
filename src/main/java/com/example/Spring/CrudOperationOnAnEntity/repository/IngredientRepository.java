package com.example.Spring.CrudOperationOnAnEntity.repository;

import com.example.Spring.CrudOperationOnAnEntity.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
