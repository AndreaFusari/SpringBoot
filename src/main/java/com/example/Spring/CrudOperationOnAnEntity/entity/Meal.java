package com.example.Spring.CrudOperationOnAnEntity.entity;

import com.example.Spring.CrudOperationOnAnEntity.entity.Ingredient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "meals")

public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int calories;
    @Column
    private double price;
    @ManyToMany(mappedBy = "meals", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    public Meal(String name, String description, int calories, double price, Long id, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.price = price;
        this.id = id;
    }

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
