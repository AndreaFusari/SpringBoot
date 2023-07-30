package com.example.Spring;

import com.example.Spring.CrudOperationOnAnEntity.entity.Meal;
import com.example.Spring.CrudOperationOnAnEntity.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class FirstController {
    @Autowired
    MealRepository mealRepository;
    private Boolean randomBoolean;
    private List<Meal> mealList = new ArrayList<>();
    //Esercizio 1
    @GetMapping(value="/hello")
    public String hello() {
        return "Hello World";
    }
    //Esercizio 2
    @GetMapping(value="/greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello World");
    }
    //Esercizio 3
    @GetMapping(value="/info")
    public ResponseEntity<ResponseBody> info() {
        return ResponseEntity.ok().build();
    }
    //Esercizio 4
    @GetMapping(value= "/random")
    public ResponseEntity<ResponseBody> random() {
        randomBoolean = new Random().nextBoolean();
        if (randomBoolean) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    //Esercizio 1.1
    @GetMapping(value="/meals")
    public List<Meal> index() {
        return mealList;
    }
    //Esercizio 2.1
    @GetMapping(value="/meals/{id}")
    public ResponseEntity<?> mealById(@PathVariable int id){
        if (id > 0 && id <= mealList.size()) {
            return ResponseEntity.ok(mealList.get(id-1));
        } else return ResponseEntity.badRequest().body("Invalid id");
    }
    //Esercizio 3.1
    @GetMapping(value="/meal/description-match/{phrase}")
    public ResponseEntity<?> mealByDescriptionMatch(@PathVariable String phrase){
        if (phrase != null) {
            return ResponseEntity.ok(mealList.stream().filter(meal -> meal.getDescription().contains(phrase)).toList());
        } else return ResponseEntity.badRequest().body("Invalid phrase");
    }
    //Esercizio 4.1
    @GetMapping(value="/meal/price/")
    public ResponseEntity<?>index(@RequestParam double min, @RequestParam double max){
        if (min >= 0 && max >= 0 && min <= max) {
            return ResponseEntity.ok(mealList.stream().filter(meal -> meal.getPrice() >= min && meal.getPrice() <= max).toList());
        } else return ResponseEntity.badRequest().body("Invalid min or max");
    }
    //Esercizio 1.2
    @PostMapping(value="/meal/")
    public ResponseEntity<?>addMeal(@RequestBody Meal meal){
        if (meal != null){
        mealList.add(meal); // mealRepository.save(meal); stiamo usando la lista invece di un db
        return ResponseEntity.ok("Meal added");
    } else return ResponseEntity.badRequest().body("Invalid meal");
    }
    //Esercizio 2.2
    @PutMapping(value="/meal/update/{name}")
   public ResponseEntity<?>updateMealByName(@PathVariable String name ,@RequestBody Meal mealUpdated){
        if (mealList.stream().anyMatch(meal -> meal.getName().equalsIgnoreCase(name))){
            mealList.stream().filter(meal -> meal.getName().equalsIgnoreCase(name)).forEach(meal -> {
                meal.setName(mealUpdated.getName());
                meal.setDescription(mealUpdated.getDescription());meal.setCalories(mealUpdated.getCalories());
                meal.setPrice(mealUpdated.getPrice());
            });
            return ResponseEntity.ok("Meal updated");

        } else return ResponseEntity.badRequest().body("Invalid meal name");
    }
    //senza usare stream e lambda
/*    public ResponseEntity<?>updateMealByName(@RequestBody Meal mealUpdated){
        for (Meal meal : mealList) {
            if (meal.getName().equals(mealUpdated.getName())) {
                meal.setName(mealUpdated.getName());
                meal.setDescription(mealUpdated.getDescription());
                meal.setCalories(mealUpdated.getCalories());
                meal.setPrice(mealUpdated.getPrice());
                return ResponseEntity.ok("Meal updated");
            }
        } return ResponseEntity.badRequest().body("Invalid meal name");
    }*/
    //Esercizio 3.2
    @DeleteMapping(value = "/delete/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name){
        if (mealList.stream().anyMatch(meal -> meal.getName().equalsIgnoreCase(name))){
            mealList.stream().filter(meal -> meal.getName().equalsIgnoreCase(name)).forEach(meal -> mealList.remove(meal)); // oppure mealList.removeIf(meal -> meal.getName().equalsIgnoreCase(name));
            return ResponseEntity.ok("Meal deleted");
        }
        else return ResponseEntity.badRequest().body("Invalid meal name");
    } //senza usare stream e lambda
        /*for (Meal meal : mealList) {
            if (meal.getName().equalsIgnoreCase(name)) {
                mealList.remove(meal);
                return ResponseEntity.ok("Meal deleted");
            }
        }*/
    //Esercizio 4.2
    @DeleteMapping(value = "/meal/price/{price}")
    public ResponseEntity<String> deleteMealAbovePrice(@PathVariable double price) {
        if (mealList.stream().anyMatch(meal -> meal.getPrice() > price)) {
            mealList.stream().filter(meal -> meal.getPrice() > price).forEach(meal -> mealList.remove(meal));
            return ResponseEntity.ok("Meal deleted");
        } else return ResponseEntity.badRequest().body("Invalid price");
    }
        //senza usare stream e lambda
        /*for (Meal meal : mealList) {
            if (meal.getPrice() > price) {
                mealList.remove(meal);
                return ResponseEntity.ok("Meal deleted");
            }
        }*/

    //Esercizio 5.2
    @PutMapping(value="/meal/update-price")
    public ResponseEntity<?> updateMealPriceByMealName(@RequestParam("nome") String nome, @RequestBody Double price){
       if (mealList.stream().anyMatch(meal->meal.getName().equalsIgnoreCase(nome))){
           mealList.stream().filter(meal->meal.getName().equalsIgnoreCase(nome)).forEach(meal -> meal.setPrice(price));
              return ResponseEntity.ok("Meal price updated");
         } else return ResponseEntity.badRequest().body("Invalid meal name");

       //senza usare stream
        /*for (Meal meal : mealList) {
            if (meal.getName().equalsIgnoreCase(nome)) {
                meal.setPrice(price);
                return ResponseEntity.ok("Meal price updated");
            }
        }
        return ResponseEntity.badRequest().body("Invalid meal name");*/
       }



}
