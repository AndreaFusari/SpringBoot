package entity;

public class Meal {
    private String name;
    private String description;
    private int calories;
    private double price;
    private int id;

    public Meal(String name, String description, int calories, double price, int id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
