package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;
import javafx.application.Platform;


public class ShellSort extends SortingAlgorithm{
    public ShellSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort(){
        int n = array.getLength();

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array.get(i);
                int j = i;
                while (j >= gap && array.get(j - gap) > temp) {
                    final int finalJ = j;
                    final int finalJGap = j - gap;
					final int finalGap = gap;
                    Platform.runLater(() -> controller.highlight(finalJ, finalJGap));
					Platform.runLater(() -> controller.showPhrase("Gap: " + finalGap));
                    sleep(1.5);

                    array.set(j, array.get(j - gap));
                    Platform.runLater(() -> controller.displayBars());
					
					
                    j -= gap;
                }
                array.set(j, temp);
                Platform.runLater(() -> controller.displayBars());
			}
		}
		
    }
}
