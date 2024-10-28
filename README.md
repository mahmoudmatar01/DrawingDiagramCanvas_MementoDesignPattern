# DrawingDiagramCanvas_MementoDesignPattern

This project demonstrates the **Memento Design Pattern** by managing a history of states for a `Canvas` object, allowing undo and redo operations on its properties. This approach is useful in applications requiring state management, such as graphics editors or document processing software.

## Project Structure

The project contains the following classes:

1. **Canvas**
   - Represents a drawable canvas object with properties: `content`, `color`, and `border`.
   - Includes `saveCanvas` to capture its current state in a `CanvasState` object (acting as a memento).
   - `restoreCanvas` allows the canvas to revert to a previously saved state.

2. **CanvasState**
   - Acts as the memento that holds a snapshot of the `Canvas` attributes (`content`, `color`, `border`).
   - Provides getter methods to retrieve stored attribute values when restoring the canvas state.

3. **CanvasHistory**
   - Manages `CanvasState` history using two stacks (`prevState` and `nextState`) to implement undo and redo functionality.
   - `saveHistoryState` pushes a state to the `prevState` stack, enabling reversal of changes if needed.
   - `undo` reverts to the last saved state by popping from `prevState` and pushing to `nextState`.
   - `redo` moves forward to the most recent state by popping from `nextState` and pushing back to `prevState`.

4. **Main**
   - Demonstrates creating a `Canvas` object and using `CanvasHistory` to save, undo, and redo changes.
   - Displays each canvas state change using a helper method `printCanvasState`.

## How It Works

1. **Initial Setup**:
   - The canvas is initialized with values: `"Initial Content"`, `"Blue"`, and `"Solid"`.
   - This initial state is saved to the history stack.

2. **State Modifications**:
   - The canvas properties are modified, and each new state is saved to the `CanvasHistory`.
   - A final modification is made without saving, demonstrating that only saved states can be undone/redone.

3. **Undo and Redo Operations**:
   - The program performs undo operations to revert the canvas to previous states in history.
   - Redo operations are used to return to the latest states, demonstrating the memento pattern in action.

## Usage

### Setup

1. Clone the repository and import it into your Java IDE.
2. Compile and run the `Main` class to see the Memento Design Pattern in action.

### Example Code

Here’s an example code snippet demonstrating the system:

```java
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
```


### Sample Output

```plaintext
Current State:
Content: Updated Content 2
Color: Green
Border: Dotted

After 1st Undo:
Content: Updated Content 1
Color: Red
Border: Dashed

After 2nd Undo:
Content: Initial Content
Color: Blue
Border: Solid

After 1st Redo:
Content: Updated Content 1
Color: Red
Border: Dashed

After 2nd Redo:
Content: Updated Content 2
Color: Green
Border: Dotted

```

