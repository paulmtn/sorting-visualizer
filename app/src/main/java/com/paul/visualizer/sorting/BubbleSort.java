package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class BubbleSort extends SortingAlgorithm{
    public BubbleSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        boolean swapped;
        int length = array.getLength();
        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                final int finalJ = j;
                Platform.runLater(() -> controller.highlight(finalJ, finalJ + 1));
                sleep();

                if (array.get(j) > array.get(j + 1)) {
                    array.swap(j, j + 1);
                    swapped = true;
                    Platform.runLater(() -> controller.displayBars());
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
