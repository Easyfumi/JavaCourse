package ru.marinin.geometry;

import ru.marinin.geometry.ClosedPolyline;
import ru.marinin.geometry.Figure;
import ru.marinin.geometry.Polyline;
import ru.marinin.geometry.Polylineable;

public class Square implements Polylineable, Areable, Moveable {
    private Point startedPoint;
    private int length;
    public Square(Point startedPoint, int length) {
        if (length<=0) throw new IllegalArgumentException();
        this.startedPoint = startedPoint;
        this.length = length;
    }
    public Square(int x, int y, int length) {
        this(new Point(x,y), length);
    }

    public void setLength(int length) {
        if (length<=0)  throw new IllegalArgumentException();
        this.length = length;
    }
    public int getArea() {
        return length*length;
    }
    public Polyline getPolyline() {
        return new ClosedPolyline(new Point(startedPoint.x, startedPoint.y),
                new Point(startedPoint.x + length, startedPoint.y),
                new Point(startedPoint.x + length, startedPoint.y + length),
                new Point(startedPoint.x, startedPoint.y + length));

    }
    public int length() {
        return length;
    }
    @Override
    public String toString() {
        return "Square is " + this.getPolyline().toString();
        //return "Square in point " + startedPoint + " with side length " + length;
    }

    @Override
    public void move(int x, int y) {
        startedPoint.move(x,y);
    }




}