package com.example.knapsack;

import java.util.Random;

public class Bag {

    private int capacity;
    private Item[] content ;
    private int count = 0;


    public Bag(){}
    public Bag(int i){

        content = new Item[i];

    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRandomCapacity(){

        Random r = new Random();
        capacity = r.nextInt(20)+10;

    }

    public Item[] getContent() {
        return content;
    }

    public Item getItem(int i){

        return content[i];

    }

    public int getCount(){

        return count;
    }

    public void setContent(Item[] content) {
        this.content = content;
    }

    public void putInBag(int i, Item newItem) {

        content[i] = newItem;
        count ++;

    }

    public void fillRandomItems(int capacity) {

        Random r = new Random();

        Item currentItem;
        for (int i = 0; i < 10; i++) {

            currentItem = new Item();
            currentItem.setItemNo(i+1);
            currentItem.setWeight(r.nextInt(capacity)+1);
            currentItem.setValue(r.nextInt(capacity*2)+1);
            currentItem.setDensity();

            putInBag(i,currentItem);
        }

    }

    public int getWeight(){


        int weight = 0;
        for (int i = 0 ; i < count; i++){
            weight = weight + content[i].getWeight();

        }

        return weight;

    }

    public int getValue(){

        int value = 0;
        for (int i = 0 ; i < count; i++){

            value = value + content[i].getValue();

        }
        return value;

    }
}
