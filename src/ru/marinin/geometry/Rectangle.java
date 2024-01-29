package ru.marinin.geometry;

import ru.marinin.geometry.Figure;
import ru.marinin.geometry.Polyline;

public class Rectangle extends Figure implements Polylineable{
    private int heigth;
    private int length;
    public Rectangle(Point startedPoint, int length, int height) {
        super(startedPoint);
        if (height<=0 || length<=0) throw new IllegalArgumentException();
        this.heigth = height;
        this.length = length;
    }
    public int getHeigth() {
        return heigth;
    }
    public void setHeigth(int heigth) {
        if (heigth<=0)  throw new IllegalArgumentException();
        this.heigth = heigth;
    }

    public void setLength(int length) {
        if (length<=0)  throw new IllegalArgumentException();
        this.length = length;
    }
    public Polyline getPolyline() {
        return new Polyline(new Point(startedPoint.x, startedPoint.y),
                new Point(startedPoint.x + length, startedPoint.y),
                new Point(startedPoint.x + length, startedPoint.y + heigth),
                new Point(startedPoint.x, startedPoint.y + heigth),
                new Point(startedPoint.x, startedPoint.y)
                );
    }
    public int getArea() {
        return heigth*length;
    }
    @Override
    public int length() {
        return length;
    }
    @Override
    public String toString() {
        return "Square in point " + startedPoint + " with height " + heigth + ", length " + length;
    }

    @Override
    public void move(int x, int y) {
        startedPoint.move(x,y);
    }


}
