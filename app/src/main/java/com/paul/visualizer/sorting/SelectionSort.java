package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;
import javafx.application.Platform;

public class SelectionSort extends SortingAlgorithm{

    public SelectionSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        for (int i = 0; i < array.getLength(); i++) {
            int min = i;
            for (int j = i; j < array.getLength(); j++) {
                if (array.get(min) > array.get(j)) {
                    min = j;
                }
            }
            final int finalMin = min;
            final int finalI = i;
            Platform.runLater(() -> controller.highlight(finalI, finalMin));
            sleep();
            array.swap(i, min);
            Platform.runLater(() -> controller.displayBars());
            
        }
    }
}
