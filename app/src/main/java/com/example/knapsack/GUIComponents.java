package com.example.knapsack;

import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;


public class GUIComponents {

    protected MainActivity ma;
    protected DataActivity da;

    protected TextView tv;
    protected EditText ed ;


    protected void displayTextView(int id, int content){

        tv = da.findViewById(id);
        tv.setText(String.valueOf(content));

    }


    protected void displayTextEdit(int id, int content){

        ed = ma.findViewById(id);
        ed.setText(String.valueOf(content));
    }

    protected void displayTextEdit(int id, String content){

        ed = ma.findViewById(id);
        ed.setText(String.valueOf(content));
    }




    protected void displayTextEdit(int id, float content){

        ed = ma.findViewById(id);
        ed.setText(String.valueOf(content));
    }

    private boolean isEmpty(EditText et) {

        String emptyOrNot = et.getText().toString().trim();

        if (emptyOrNot.isEmpty() || emptyOrNot.length() == 0 || emptyOrNot.equals("") || emptyOrNot == null) {
            return true;
        } else {
            return false;
        }
    }


    protected String getText(TextView view){

        return view.getText().toString();

    }

    protected int getTextAsInt(TextView view){


        return Integer.valueOf(getText(view));

    }


}