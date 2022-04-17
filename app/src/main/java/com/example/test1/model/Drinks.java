package com.example.test1.model;

import androidx.annotation.NonNull;

public class Drinks {
    private String category;
    private String name;
    private int UnitPrice;


    public Drinks(String category, String name, int unitPrice) {
        this.category = category;
        this.name = name;
        UnitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catigory) {
        this.category = catigory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        UnitPrice = unitPrice;
    }

    @NonNull
    @Override
    public String toString() {
        return getName()+", Price: "+getUnitPrice();
    }
}
