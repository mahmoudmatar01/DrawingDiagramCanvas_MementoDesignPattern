package org.DrawingDiagramCanvas_MementoDesignPattern;

public class Canvas {

    private String content;
    private String color;
    private String border;

    public Canvas() {
        this.content = "";
        this.color = "";
        this.border = "";
    }

    public CanvasState saveCanvas(){
        return new CanvasState(content, color, border);
    }

    public void restoreCanvas(CanvasState canvasState){
        content = canvasState.getContent();
        color = canvasState.getColor();
        border = canvasState.getBorder();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }
}
