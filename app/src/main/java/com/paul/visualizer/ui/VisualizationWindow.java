package com.paul.visualizer.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import com.paul.visualizer.sorting.*;

import com.paul.visualizer.data.ArrayData;

public class VisualizationWindow extends Application{

    private Canvas canvas;
    private VisualizationController controller;
    private ArrayData array;
    private SortingAlgorithm sortingAlgorithm;

    @Override
    public void start(Stage mainStage){
        HBox controls = new HBox(10); // 10px spacing
        controls.setPadding(new Insets(10));
        Button shuffleButton = new Button("Shuffle");
        Button startButton = new Button("Start Sort");
        Slider speedSlider = new Slider(1, 500, 250);
        Label speedLabel = new Label("Speed:");
        ChoiceBox<String> cb = new ChoiceBox<>(FXCollections.observableArrayList(
        "Selection Sort", "Bubble Sort", "Insertion Sort", "Shell Sort", "Merge Sort", "Quick Sort", "Radix Sort", "Heap Sort"));
        cb.setValue("Selection Sort");
        controls.getChildren().addAll(shuffleButton, startButton, speedLabel, speedSlider, cb);


        

        canvas = new Canvas(1000, 700);
        VBox root = new VBox(controls, canvas);
        array = new ArrayData();
        controller = new VisualizationController(canvas, array);
        

        Scene scene = new Scene(root, 1000, 700);
        mainStage.setScene(scene);
        mainStage.setTitle("Sorting Visualizer");

        controller.displayBars();

        startButton.setOnAction(e -> {
            String selectedAlgorithm = cb.getValue();
            double speed = speedSlider.getValue();

            switch (selectedAlgorithm) {
                case "Selection Sort":
                    sortingAlgorithm = new SelectionSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Bubble Sort":
                    sortingAlgorithm = new BubbleSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Insertion Sort":
                    sortingAlgorithm = new InsertionSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Shell Sort":
                    sortingAlgorithm = new ShellSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Merge Sort":
                    sortingAlgorithm = new MergeSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Quick Sort":
                    sortingAlgorithm = new QuickSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Radix Sort":
                    sortingAlgorithm = new RadixSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
                case "Heap Sort":
                    sortingAlgorithm = new HeapSort(controller, array, speed);
                    new Thread(() -> sortingAlgorithm.sort()).start();
                    break;
            }
        });

        shuffleButton.setOnAction(e -> {
            array.shuffle();
            update();
        });

        mainStage.show();


    }

    private void update() {
        controller.displayBars();
    }
}
