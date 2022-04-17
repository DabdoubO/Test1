package com.example.test1.model;

import java.util.ArrayList;

public class DrinksMockUp {

    private ArrayList<Drinks> drinks = new ArrayList<>();


    public DrinksMockUp(){
        drinks.add(new Drinks("Cold Drinks", "Cold Water", 5));
        drinks.add(new Drinks("Cold Drinks", "Latte", 15));
        drinks.add(new Drinks("Cold Drinks", "Cold Americano", 15));
        drinks.add(new Drinks("Cold Drinks", "Ice Coffee", 15));
        drinks.add(new Drinks("Hot Drinks", "Tea", 10));
        drinks.add(new Drinks("Hot Drinks", "Americano", 10));
        drinks.add(new Drinks("Hot Drinks", "Arabic coffee", 6));
        drinks.add(new Drinks("Hot Drinks", "Mocha", 15));
        drinks.add(new Drinks("Soda", "Coca-Cola", 8));
        drinks.add(new Drinks("Soda", "Sprite", 8));
        drinks.add(new Drinks("Soda", "Sparkling Water", 6));
        drinks.add(new Drinks("Soda", "Italian Soda Coffee", 16));
        drinks.add(new Drinks("Fresh", "Apple", 18));
        drinks.add(new Drinks("Fresh", "Orange", 18));
        drinks.add(new Drinks("Fresh", "Mango", 18));
        drinks.add(new Drinks("Fresh", "Water", 5));

    }

    public ArrayList<Drinks> getDrinks (String cat){

        ArrayList<Drinks> result = new ArrayList<>();

        for (Drinks d : drinks){
            if(d.getCategory().equals(cat)){
                result.add(d);
            }
        }
        return result;
    }

    public String[] getCategories(){
        String[] cat = {"Cold Drinks", "Hot Drinks", "Soda", "Fresh"};
        return cat;
    }


}