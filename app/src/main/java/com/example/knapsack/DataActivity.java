package com.example.knapsack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {

    OutputGUI ogui = new OutputGUI(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        // MainActivity.outputBag;
        // pass the bag to GUI to display

        BagManager bm = new BagManager();
        bm.setWeightLimit(MainActivity.bm.getWeightLimit());
        bm.setInputBag(MainActivity.bm.getInputBag());
        bm.sortInputBag();
        bm.setOutputBag(10);

        bm.putInOutputBag();

        System.out.println("What is the first item's weight in the outputBag? = "+bm.getOutputBag().getItem(0).getWeight());

        System.out.println("Bag Count = "+ bm.getOutputBag().getCount());

        Bag b = bm.getOutputBag();

       if(bm.getOutputBag().getItem(0)==null){



       } else {

           ogui.displayBagContent(b);

           ogui.displayTotal(b);
          // ogui.displayTotal(b);
       }

    }

    public void back(android.view.View v){

        this.finish();
    }

    protected TextView tv;

    protected void displayTextView(int id, float content){

        tv = findViewById(id);
        tv.setText(String.valueOf(content));

    }
}