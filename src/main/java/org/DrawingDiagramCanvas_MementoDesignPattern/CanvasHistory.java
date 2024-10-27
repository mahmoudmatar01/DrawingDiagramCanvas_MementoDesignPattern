package org.DrawingDiagramCanvas_MementoDesignPattern;

import java.util.Stack;

public class CanvasHistory {

    private final Stack<CanvasState> prevState;
    private final Stack<CanvasState> nextState;

    public CanvasHistory() {
        this.prevState = new Stack<>();
        this.nextState = new Stack<>();
    }

    public void saveHistoryState(CanvasState canvasState) {
        prevState.push(canvasState);
        nextState.clear();
    }

    public CanvasState undo() {
        if (!prevState.isEmpty()) {
            CanvasState currentState = prevState.pop();
            nextState.push(currentState);
            return currentState;
        }
        return null;
    }

    public CanvasState redo() {
        if (!nextState.isEmpty()) {
            CanvasState state = nextState.pop();
            prevState.push(state);
            return state;
        }
        return null;
    }
}
