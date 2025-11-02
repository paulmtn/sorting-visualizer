package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

import javafx.application.Platform;

public class MergeSort extends SortingAlgorithm{
    public MergeSort(VisualizationController controller, ArrayData array, double speed) {
        super(controller, array, speed);
    }

    public void sort() {
        mSort(0, 99);
    }

    public void mSort(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mSort(left, mid);
            mSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    public void merge(int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;

        int tempL[] = new int[length1];
        int tempR[] = new int[length2];

        for(int i = 0; i < length1; i++) {
            tempL[i] = array.get(i + left);
        }
        for(int i = 0; i < length2; i++) {
            tempR[i] = array.get(i + mid + 1);
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < length1 && j < length2) {
            if (tempL[i] <= tempR[j]) {
                array.set(k, tempL[i]);
                i++;
            } else {
                array.set(k, tempR[j]);
                j++;
            }
            Platform.runLater(() -> controller.displayBars());
            sleep();
            k++;
        }

        // add remaining items into the array
        while (i < length1) {
            array.set(k, tempL[i]);
            i++;
            k++;
        }

        while (j < length2) {
            array.set(k, tempR[j]);
            j++;
            k++;
        }

    }
}
