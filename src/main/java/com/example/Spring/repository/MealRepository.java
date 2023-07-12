package com.example.Spring.repository;

import com.example.Spring.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal,Long> {

}
