package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class InsertionSort extends SortingAlgorithm{
    public InsertionSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        int length = array.getLength();
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && array.get(j - 1) > array.get(j)) {
                final int finalJ = j;
                Platform.runLater(() -> controller.highlight(finalJ - 1, finalJ));
                sleep();
                array.swap(j - 1, j);
                Platform.runLater(() -> controller.displayBars());
                j--;
            }

            
        }
    }
}
