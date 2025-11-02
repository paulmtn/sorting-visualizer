package com.paul.visualizer.sorting;

import com.paul.visualizer.data.ArrayData;
import com.paul.visualizer.ui.VisualizationController;

public abstract class SortingAlgorithm {
    protected VisualizationController controller;
    protected ArrayData array;
    protected String name;
    protected double speed;

    public SortingAlgorithm(VisualizationController controller, ArrayData array, double speed) {
        this.controller = controller;
        this.array = array;
        this.speed = speed;
    }

    public abstract void sort();

    public void sleep() {
        try {
            Thread.sleep((long)(501 - speed));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    } 

    public void sleep(double scale) {
        try {
            Thread.sleep((long)((501 - speed) * scale));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public String getName() {
        return name;
    }
}
