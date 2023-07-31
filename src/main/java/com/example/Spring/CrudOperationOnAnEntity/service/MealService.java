package com.example.Spring.CrudOperationOnAnEntity.service;

import com.example.Spring.CrudOperationOnAnEntity.entity.Meal;
import com.example.Spring.CrudOperationOnAnEntity.repository.MealRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    private final Double WINTER_TEMP = 10.00;
    @Autowired
    private MealRepository mealRepository;
    public void createMeal(Meal meal){
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

    public List<Meal> getWinterMeals(){
           Double currentTemp = getCurrentMilanoTemperature();
           if(currentTemp<=WINTER_TEMP){
        return mealRepository.findByIsWinterMeal(true);

           } else return new ArrayList<>();

    }

    private Double getCurrentMilanoTemperature()  {
        try { JSONObject response =
                Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=45.5921&longitude=9.5734&current_weather=true").asJson().getBody().getObject();
            return response.getJSONObject("current_weather").getDouble("temperature");
        } catch (UnirestException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
