package com.example.knapsack;

import java.text.DecimalFormat;

public class Item {


    private int itemNo, weight, value;

    private float fraction, density;


    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity() {
        density = (float) value / (float) weight;
    }
}