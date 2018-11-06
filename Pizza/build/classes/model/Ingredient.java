package model;

import java.text.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.binding.*;

public class Ingredient {
    //private String name;
    private StringProperty name = new SimpleStringProperty();
    private double price;
    private DoubleProperty priceProperty = new SimpleDoubleProperty();
    private Category category;
    private IntegerProperty sold = new SimpleIntegerProperty();
    private IntegerProperty soldProperty = new SimpleIntegerProperty();
    private DoubleProperty incomeProperty = new SimpleDoubleProperty();
    

    public Ingredient(String name, double price, Category category) {
        //this.nameProperty.set(nameProperty);
        this.name.set(name);
        this.priceProperty.set(price);
        this.price = price;
        sold.set(0);
        this.category = category;
        //soldProperty.bind(sold);
        incomeProperty.bind(sold.multiply(price));
    }

    public void sell() {
        sold.set(sold.get() + 1);
        //soldProperty.set(sold);
        //come back here!!!
    }

    public boolean in(Category category) {
        return this.category == category;
    }
//
    public String getName() {
        return name.get();
    }
//
    public double getPrice() {
        return price;
    }
//
//    public int getSold() {
//        return sold;
//    }

    public double getIncome() {
        return sold.get() * priceProperty.get();
    }

    public Category getCategory() {
        return category;
    }
    
    public final String getNameProperty() {
        return name.get();
    }
    
    public StringProperty nameProperty() {
        return name;
    }
    
    public final void setName(String name) { this.name.set(name); }
    
    
    public final Double getPriceProperty() {
        return priceProperty.get();
    }
    
    public DoubleProperty priceProperty() {
        return priceProperty;
    }
    
    public final Integer getSoldProperty() {
        return sold.get();
    }
    
    public IntegerProperty soldProperty() {
        return sold;
    }
    
    
    
    public void income() {
        incomeProperty.set(getIncome()); 
    }
    public DoubleProperty getIncomeProperty() {
        return incomeProperty;
    }

    @Override
    public String toString() {
        return name.get() + " " + category;
    }

    private String formatted(double n) {
        return new DecimalFormat("###,##0.00").format(n);
    }
}
