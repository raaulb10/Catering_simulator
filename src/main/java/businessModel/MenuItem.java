package businessModel;

import java.io.Serializable;

abstract public class MenuItem implements Serializable {

    protected String name;
    protected double rating;
    protected int calories;
    protected int protein;
    protected int fat;
    protected int sodium;
    protected int price;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }
    public int getProtein() { return protein; }
    public void setProtein(int protein) { this.protein = protein; }
    public int getFat() { return fat; }
    public void setFat(int fat) { this.fat = fat; }
    public int getSodium() { return sodium; }
    public void setSodium(int sodium) { this.sodium = sodium; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

}
