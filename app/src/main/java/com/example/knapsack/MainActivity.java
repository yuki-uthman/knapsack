package com.example.knapsack;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

     private MediaPlayer mp;
     private InputGUI igui;
     public static BagManager bm = new BagManager();
     public static Bag inputBag , outputBag;
     private boolean generate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this,R.raw.android_click);
        igui = new InputGUI(this);
        inputBag = new Bag(10);
        outputBag = new Bag(10);



    }

    // if a user clicks on the capacity input
    // set generateCount = false

    public void done(android.view.View v){

        mp.start();
        if(generate) {
            Intent i = new Intent(this, DataActivity.class);
            this.startActivity(i);
        }

        // set the inputBag generated
        // get all the input into the bag and pass to the bag manager
        // set the inputBag generated
        // set the capacity of outputBag

      /*  for(int i = 0 ; i < 10; i++) {  new stuffss
            inputBag.putInBag(i, igui.getItem(i));
        }

        outputBag.setCapacity(igui.getCapacity());
*/

    }

    public void random (android.view.View v) {

        mp.start();
        generate = true;
/*
        if(gui.isCapacityInputEmpty() || gui.getGenerateCount()){

            inputBag.setCapacity(10);
            gui.displayBagCapacity(inputBag);
          //  gui.setCapacityInput();
        }*/

      //  igui.generate(); new


        bm.setRandomLimit();
        igui.displayTextEdit(IDs.capacityInput[0], bm.getWeightLimit());

        Bag inputBag = new Bag(10);

        bm.setInputBag(inputBag);
        bm.fillInputBag();

        // display only

        igui.displayBagContent(bm.getInputBag());

    }
}
