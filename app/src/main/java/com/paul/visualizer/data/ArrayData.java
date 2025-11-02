package com.paul.visualizer.data;

import java.util.Arrays;
import java.util.Random;

public class ArrayData {
    int[] array;
    int arrayLength;

    public ArrayData(){
        resize(100);
    }

    private void setLength(int length) {
        arrayLength = length;
    }

    public int getLength() {
        return arrayLength;
    }

    public int get(int i) {
        return array[i];
    }

    public void resize(int size){
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }

        setLength(size);
        shuffle();

    }

    public void shuffle() {
        Random random = new Random();
        for (int i = getLength() - 1; i > 0; i--) {
            int j = random.nextInt(i+1);
            swap(i, j);
        }
    }

    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public void set(int i, int value) {
        array[i] = value;
    }
}
