package com.example.Spring.CrudOperationOnAnEntity.repository;

import com.example.Spring.CrudOperationOnAnEntity.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {
    List<Meal> findByIsWinterMeal(boolean isWinterMeal);

}
