package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class QuickSort extends SortingAlgorithm{
    public QuickSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        quickSort(0, array.getLength() - 1);
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    public int partition(int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            final int finalI = i;
            final int finalJ = j;
            Platform.runLater(() -> controller.highlight(finalI + 1, finalJ));
            sleep();
            if (array.get(j) < pivot) {
                i++;
                array.swap(i, j);
                Platform.runLater(() -> controller.displayBars());
                sleep();
            }
        }
        array.swap(i+1, high);
        Platform.runLater(() -> controller.displayBars());
        sleep();
        
        return i + 1;
    }
}