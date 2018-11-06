    package model;

import java.util.LinkedList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kitchen {
    public static final Category CRUST = new Category("crust", 1, 1);
    public static final Category SAUCE = new Category("sauce", 1, 1);
    public static final Category TOPPING = new Category("topping", 2, 3);
    private Category[] categories = { CRUST, SAUCE, TOPPING };
    private ObservableList<Ingredient> ingredients = FXCollections.observableArrayList();
    private StringProperty ingrString = new SimpleStringProperty();

    

    public Kitchen() {
        // Don't change these ingredients
        ingredients.add(new Ingredient("Thin", 3.00, Kitchen.CRUST));
        ingredients.add(new Ingredient("Thick", 3.50, Kitchen.CRUST));
        ingredients.add(new Ingredient("Tomato", 1.00, Kitchen.SAUCE));
        ingredients.add(new Ingredient("Barbeque", 1.00, Kitchen.SAUCE));
        ingredients.add(new Ingredient("Capsicum", 0.50, Kitchen.TOPPING));
        ingredients.add(new Ingredient("Olives", 1.50, Kitchen.TOPPING));
        ingredients.add(new Ingredient("Jalapenos", 1.00, Kitchen.TOPPING));
        ingredients.add(new Ingredient("Beef", 2.75, Kitchen.TOPPING));
        ingredients.add(new Ingredient("Pepperoni", 2.50, Kitchen.TOPPING));
    }

    public Category[] getCategories() {
        return categories;
    }

    public final ObservableList<Ingredient> getIngredients() {
        return ingredients;
    }
    

    public double getIncome() {
        double sum = 0.0;
        for (Ingredient ingredient : ingredients)
            sum += ingredient.getIncome();
        return sum;
    }
}
