package com.example.knapsack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BagManager {


    private Bag inputBag , outputBag;

    private int weightLimit;


    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public void setRandomLimit(){

        Random r = new Random();
        weightLimit = r.nextInt(35)+15;

    }

    public Bag produceOutputBag() {

        Bag outputBag = new Bag(3);
        Random r = new Random();
        for (int i = 0; i < 3; i++) {

            Item outputItem = inputBag.getItem(r.nextInt(10));
            outputBag.putInBag(i, outputItem);
        }
        return outputBag;
    }

    public void setInputBag( Bag inputBag){

        this.inputBag = inputBag;
    }

    public void setInputBag(){

        inputBag = new Bag(10);


    }

    public void fillInputBag(){

        Random r = new Random();

        Item currentItem;
        for (int i = 0; i < 10; i++) {

            currentItem = new Item();
            currentItem.setItemNo(i+1);
            currentItem.setWeight(r.nextInt(weightLimit)+1);
            currentItem.setValue(r.nextInt(weightLimit*2)+1);
            currentItem.setDensity();
            putInBag(inputBag, i, currentItem);
        }

    }

    private void putInBag(Bag b, int i, Item item){

        b.putInBag(i, item);

    }

    public void putInOutputBag() {

        int remainingWeight= weightLimit;

        for(int i = 0; remainingWeight > 0; i++ ){


            Item currentItem = inputBag.getItem(i);
            if (currentItem.getWeight() <= remainingWeight ) {
                currentItem.setFraction(100);
                remainingWeight = remainingWeight - currentItem.getWeight();
                outputBag.putInBag(i,currentItem);

            } else {
                int weight = currentItem.getWeight();
                float fraction = (float)remainingWeight/weight;

                float newWeight = weight * fraction;
                int newWeight2 = Math.round(newWeight);
                currentItem.setWeight(newWeight2);
                currentItem.setFraction(fraction*100);
                outputBag.putInBag(i,currentItem);
                return;
            }
        }
    }

    public int calculateTotalWeight() {

        int sum = 0;
        for (int i = 0 ; i < outputBag.getCount(); i++){

            sum = sum + outputBag.getItem(i).getWeight();

        }


        return sum;
    }

    public int calculateTotalValue() {

        int sum = 0;
        for (int i = 0 ; i < outputBag.getCount(); i++){

            sum = sum + outputBag.getItem(i).getValue();

        }
        return sum;
    }

    public Bag getInputBag() {
        return inputBag;
    }

    public Bag getOutputBag() {
        return outputBag;
    }

    public void setOutputCapacity(){

        outputBag = new Bag(10);
        outputBag.setRandomCapacity();

    }

    public void setOutputBag(){
        this.outputBag = new Bag();

    }

    public void setOutputBag(int i) {
        this.outputBag = new Bag(i);
    }

    public void sortInputBag(){

        quickSort(inputBag.getContent(),0,9);
        Collections.reverse(Arrays.asList(inputBag.getContent()));
      //  return inputBag.getContent();

    }

    private void quickSort(Item arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private  int partition(Item arr[], int begin, int end) {
        float pivot = arr[end].getDensity();
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j].getDensity() <= pivot) {
                //      System.out.println(arr[j] +" <= "+ pivot);
                i++;
                //      System.out.println("i = "+i);
                //     System.out.println("j = "+j);
                Item swapTemp = arr[i];
                //    System.out.println("swapTemp = "+arr[i]);
                //     System.out.println("arr["+ i +"] <- "+arr[j]);
                //     System.out.println("arr["+j+"] <- "+ swapTemp);
                arr[i] = arr[j];
                arr[j] = swapTemp;


            }
        }

        Item swapTemp = arr[i+1];

        //   System.out.println("arr[i+1] = "+ arr[i+1]);
        //    System.out.println("arr["+ i+1 +"] <- "+arr[end]);
        //    System.out.println("arr["+end+"] <- "+ swapTemp);
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        for(int k = 0 ; k < arr.length ; k++ ){
            //   System.out.print(arr[k]+" , ");
        }

        //   System.out.println();

        return i+1;
    }
}
