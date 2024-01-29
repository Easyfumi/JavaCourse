package ru.marinin.geometry;

public class Circle extends Figure {
    private int r;
    public Circle(Point startedPoint, int r) {
        super(startedPoint);
        if (r<=0) throw new IllegalArgumentException();
        this.r = r;
    }
    public int getArea() {
        return (int) (Math.PI*r*r);
    }
    public int getR() {
        return r;
    }

    public void setR(int r) {
        if (r<=0) throw new IllegalArgumentException();
        this.r = r;
    }
    @Override
    public int length() {
        return (int) (2*Math.PI*r);
    }
    @Override
    public String toString() {
        return "Circle with a middlePoint " + startedPoint + " and a radius of " + r;
    }

    @Override
    public void move(int x, int y) {
        this.startedPoint.x = this.startedPoint.x + x;
        this.startedPoint.y = this.startedPoint.y + y;
    }


}
