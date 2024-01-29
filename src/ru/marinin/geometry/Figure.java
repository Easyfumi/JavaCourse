package ru.marinin.geometry;

public abstract class Figure implements Areable, Lengthable {
    public Point startedPoint;
    public Figure(Point startedPoint) {
        this.startedPoint = startedPoint;
    }

}
