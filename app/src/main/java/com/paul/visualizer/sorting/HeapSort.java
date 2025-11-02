package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class HeapSort extends SortingAlgorithm{
    public HeapSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void heapify(int n, int i) {
        // assume i is the largest value
        // n refers to the index of the end of the array
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array.get(left) > array.get(largest)) {
            largest = left;
        }

        if (right < n && array.get(right) > array.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            final int finalI = i; 
            final int finalLargest = largest;

            Platform.runLater(() -> controller.highlight(finalI, finalLargest));
            sleep();
            array.swap(i, largest);

            Platform.runLater(() -> controller.displayBars());
            sleep();
            heapify(n, largest);
        }
    }

    public void sort() {
        int length = array.getLength();

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            array.swap(0, i);
            Platform.runLater(() -> controller.displayBars());
            sleep();

            heapify(i, 0);
        }
    }
}
