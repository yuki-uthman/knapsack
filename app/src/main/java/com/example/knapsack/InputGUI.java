package com.example.knapsack;


import android.widget.EditText;

import java.util.Random;

public class InputGUI extends GUIComponents{

    Random r = new Random();
    EditText edit;

    public InputGUI(MainActivity ma) {

        this.ma = ma;

    }

    public int getCapacity(){

        ed = ma.findViewById(IDs.capacityInput[0]);
        return getTextAsInt(ed);

    }

    public void generate(){

        int capacity = r.nextInt(40)+10;
        displayTextEdit(IDs.capacityInput[0],capacity);
        for (int i = 0; i < 10; i++) {
            displayTextEdit(IDs.weightInputID[i], r.nextInt(capacity)+1);
            displayTextEdit(IDs.valueInputID[i], r.nextInt(capacity*2)+1);
        }


    }

    public Item getItem(int i){

        Item currentItem = new Item();

        ed = ma.findViewById(IDs.itemInputID[i]);
        int id = getTextAsInt(ed);

        ed = ma.findViewById(IDs.weightInputID[i]);
        int weight = getTextAsInt(ed);

        ed = ma.findViewById(IDs.valueInputID[i]);
        int value = getTextAsInt(ed);

        currentItem.setItemNo(id);
        currentItem.setWeight(weight);
        currentItem.setValue(value);
        currentItem.setDensity();

        return currentItem;

    }

    public Bag transferToBag(Bag b){

        Item currentItem;
        for(int i = 0 ; i < 10 ; i++) {

            currentItem = new Item();

            ed = ma.findViewById(IDs.itemInputID[i]);
            int id = getTextAsInt(ed);

            ed = ma.findViewById(IDs.weightInputID[i]);
            int weight = getTextAsInt(ed);

            ed = ma.findViewById(IDs.valueInputID[i]);
            int value = getTextAsInt(ed);

            currentItem.setItemNo(id);
            currentItem.setWeight(weight);
            currentItem.setValue(value);
            currentItem.setDensity();

            b.putInBag(i,currentItem);

        }

        return b;

    }

    public void displayBagCapacity(Bag b){

        displayTextEdit(IDs.capacityInput[0], b.getCapacity());

    }

    public void displayBagContent(Bag b) {

        for (int i = 0; i < 10; i++) {
            Item[] content = b.getContent();
            displayTextEdit(IDs.weightInputID[i], content[i].getWeight());
            displayTextEdit(IDs.valueInputID[i], content[i].getValue());
        }

    }


}
