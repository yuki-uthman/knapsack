package com.example.knapsack;

import android.widget.TextView;

import java.text.DecimalFormat;

public class OutputGUI extends GUIComponents{

    DecimalFormat densityFormat = new DecimalFormat("0.0");
    DecimalFormat fractionFormat = new DecimalFormat("0");
    DecimalFormat totalWeightFormat = new DecimalFormat("0 kg");
    DecimalFormat totalValueFormat = new DecimalFormat("$ 0");



    public OutputGUI(DataActivity da) {

        this.da = da;

    }

    public void displayBagContent(BagManager bm ){

        Bag b = bm.getOutputBag();
        Item [] content = b.getContent();
        for(int i = 0 ; i < b.getCount(); i++){

            displayTextView(IDs.itemOutputID[i], content[i].getItemNo());
            displayTextView(IDs.weightOutputID[i],content[i].getWeight());
            displayTextView(IDs.valueOutputID[i], content[i].getValue());
            displayTextView(IDs.densityOutputID[i], content[i].getDensity() , densityFormat);
        }
    }

   public void displayBagContent(Bag b){


        Item[] content = b.getContent();

        for(int i = 0 ; i < b.getCount(); i++){

            displayTextView(IDs.itemOutputID[i], content[i].getItemNo());
            displayTextView(IDs.weightOutputID[i],content[i].getWeight());
            displayTextView(IDs.valueOutputID[i], content[i].getValue());
            displayTextView(IDs.densityOutputID[i], b.getItem(i).getDensity() , densityFormat);
            displayTextView(IDs.fractionOutputID[i], b.getItem(i).getFraction(), fractionFormat);
        }

    }

    public void displayTotal(BagManager bm){

        Bag b = bm.getOutputBag();

        displayTextView(IDs.totalWeight, b.getWeight());
        displayTextView(IDs.totalValue, b.getValue());


    }

    public void displayTotal(Bag b){

        displayTextView(IDs.totalWeight, b.getWeight(), totalWeightFormat);
        displayTextView(IDs.totalValue, b.getValue() , totalValueFormat);

    }

    protected void displayTextView(int id, float content , DecimalFormat df){

        tv = da.findViewById(id);
        String s = df.format(content);
        tv.setText(s);

    }

}
