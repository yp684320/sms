package day11.Test3;

public class Apple {
    private double size;
    private String color;

    public Apple() {
    }

    public Apple(double size, String color) {
        this.size = size;
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  size + "-" + color ;
    }
}
