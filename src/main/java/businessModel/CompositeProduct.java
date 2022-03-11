package businessModel;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {

    public List<MenuItem> itemList;

    public CompositeProduct(String name, ArrayList<MenuItem> itemList) {
        this.name = name;
        this.itemList = itemList;
        computeValues();
    }


    private void computeValues(){
        rating = 0;
        calories = 0;
        protein = 0;
        fat = 0;
        sodium = 0;
        price = 0;
        int nr=0;
        for(MenuItem item: itemList){
            rating += item.getRating();
            calories += item.getCalories();
            protein += item.getProtein();
            fat += item.getFat();
            sodium += item.getSodium();
            price += item.getPrice();
            nr++;
        }
        rating=rating/nr;
    }

    @Override
    public String toString() {
        return " | name  - " + name + " | rating - " + rating +
                " | calories - " + calories + " | protein - " + protein + " | fat - " + fat +
                " | sodium - " + sodium + " | price - " + price + "\n";
    }
}
