package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class RadixSort extends SortingAlgorithm{
    public RadixSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        int max = 100;

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(exp);

            final int currentExp = exp;
            Platform.runLater(() -> {
                controller.displayBars();
                controller.showPhrase("Digit place: " + currentExp);
            });
            sleep();

        }
        
    }

    private void countingSortByDigit(int exp) {
        int n = array.getLength();
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (array.get(i) / exp) % 10;
            count[digit] ++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        // Places elements into the output array iterating backwards
        // It doesn't matter the order because it is sorted out with the other decimals
        for (int i = n - 1; i >= 0; i--) {
            int val = array.get(i);
            int digit = (val / exp) % 10;
            output[count[digit] - 1] = val;
            count[digit]--;
        }

        for (int i = 0; i < n; i++) {
            array.set(i, output[i]);
            Platform.runLater(() -> controller.displayBars());
            sleep();
        }

    }

}
