package controller;

import entity.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class FirstController {
    private Boolean randomBoolean;
    private List<Meal> mealList = List.of(
            new Meal("Pasta Bolognese", "Pasta with meat sauce",1200, 9.99 ,1),
            new Meal("Pasta Carbonara", "Pasta with creamy bacon sauce",1400, 8.99,2),
            new Meal("Wiener Schnitzel", "Fried pork with potatoes",800, 7.99,3),
            new Meal("Salmon Steak", "Grilled salmon with vegetables",900, 10.99,4),
            new Meal("Apple Pie", "Apple pie with vanilla ice cream",670, 5.99,5),
            new Meal("Chocolate Mousse", "Chocolate mousse with whipped cream",987, 4.99,6));

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


}
