package com.paul.visualizer.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import com.paul.visualizer.data.ArrayData;

public class VisualizationController {
    private Canvas canvas;
    private ArrayData array;
    final int heightScale = 6;

    public VisualizationController(Canvas canvas, ArrayData array) {
        this.canvas = canvas;
        this.array = array;
    }

    /** Draws the current state of the array as bars on the canvas
     * Clears before drawing
     */
    public void displayBars() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int canvasHeight = (int)canvas.getHeight();
        int canvasWidth = (int)canvas.getWidth();
        int numBars = array.getLength();
        int barWidth = canvasWidth / (numBars + 11);
        int spacing = 1;
        int y;

        for (int i = 0; i < numBars; i++) {
            int x = i * (barWidth + spacing) + 1;
            int barHeight = array.get(i) * heightScale;
            y = canvasHeight - barHeight - 45;
            gc.fillRect(x, y, barWidth, barHeight);
        }
        
    }

    /** 
     * Highlights two bard to indicate a comparison during sorting
     */
    public void highlight(int i, int j) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        displayBars();
        
        int canvasHeight = (int)canvas.getHeight();
        int canvasWidth = (int)canvas.getWidth();
        int numBars = array.getLength();
        int barWidth = canvasWidth / (numBars + 11);
        int spacing = 1;
        int y;
        int x;

        x = i * (barWidth + spacing) + 1;
        int barHeight = array.get(i) * heightScale;
        y = canvasHeight - barHeight - 45;
        gc.setFill(javafx.scene.paint.Color.RED);
        gc.fillRect(x, y, barWidth, barHeight);

        x = j * (barWidth + spacing) + 1;
        barHeight = array.get(j) * heightScale;
        y = canvasHeight - barHeight - 45;
        gc.fillRect(x, y, barWidth, barHeight);

        gc.setFill(javafx.scene.paint.Color.BLACK);
    }

    public void showPhrase(String phrase) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillText(phrase, 10, 10, 50);
    }
}
