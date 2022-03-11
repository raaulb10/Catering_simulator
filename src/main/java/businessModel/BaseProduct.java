package businessModel;

public class BaseProduct extends MenuItem {

    public BaseProduct(String name, double rating, int calories, int protein, int fat, int sodium, int price) {
        this.name = name;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name  - " + name + " | rating - " + rating +
                " | calories - " + calories + " | protein - " + protein + " | fat - " + fat +
                " | sodium - " + sodium + " | price - " + price;
    }
}
