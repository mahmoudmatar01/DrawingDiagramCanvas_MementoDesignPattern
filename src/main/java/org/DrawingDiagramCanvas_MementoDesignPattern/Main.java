package org.DrawingDiagramCanvas_MementoDesignPattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a new Canvas and CanvasHistory instance
        Canvas canvas = new Canvas();
        CanvasHistory history = new CanvasHistory();

        // Set initial state and save it
        canvas.setContent("Initial Content");
        canvas.setColor("Blue");
        canvas.setBorder("Solid");
        history.saveHistoryState(canvas.saveCanvas());

        // Make some changes and save states
        canvas.setContent("Updated Content 1");
        canvas.setColor("Red");
        canvas.setBorder("Dashed");
        history.saveHistoryState(canvas.saveCanvas());

        canvas.setContent("Updated Content 2");
        canvas.setColor("Green");
        canvas.setBorder("Dotted");
//        history.saveHistoryState(canvas.saveCanvas());

        // Print the current state
        System.out.println("Current State:");
        printCanvasState(canvas);

        // Undo the last change
        canvas.restoreCanvas(history.undo());
        System.out.println("\nAfter 1st Undo:");
        printCanvasState(canvas);

        //  Undo another change
        canvas.restoreCanvas(history.undo());
        System.out.println("\nAfter 2nd Undo:");
        printCanvasState(canvas);

        // Redo the last undo
        canvas.restoreCanvas(history.redo());
        System.out.println("\nAfter 1st Redo:");
        printCanvasState(canvas);

        // Redo again to the latest state
        canvas.restoreCanvas(history.redo());
        System.out.println("\nAfter 2nd Redo:");
        printCanvasState(canvas);
    }

    // Helper method to print the current canvas state
    private static void printCanvasState(Canvas canvas) {
        System.out.println("Content: " + canvas.getContent());
        System.out.println("Color: " + canvas.getColor());
        System.out.println("Border: " + canvas.getBorder());
    }
}