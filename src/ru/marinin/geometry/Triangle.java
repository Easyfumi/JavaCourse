package ru.marinin.geometry;

public class Triangle extends Figure implements Polylineable {
    Point secondPoint;
    Point thirdPoint;
    public Triangle(Point startedPoint, Point secondPoint, Point thirdPoint) {
        super(startedPoint);
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }
    public Polyline getPolyline() {
        return new ClosedPolyline(new Point(startedPoint.x, startedPoint.y),
                new Point(secondPoint.x, secondPoint.y),
                new Point(thirdPoint.x, thirdPoint.y)
        );
    }
    public int getArea() {
        Line aLine = new Line(startedPoint, secondPoint);
        Line bLine = new Line(secondPoint, thirdPoint);
        Line cLine = new Line(thirdPoint, startedPoint);
        double a = aLine.length();
        double b = bLine.length();
        double c = cLine.length();
        double p = (a + b + c)/2;
        return (int) Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    @Override
    public int length() {
        return this.getPolyline().length();
    }
    @Override
    public String toString() {
        return "ru.marinin.geometry.Triangle has three points: " + startedPoint + " ; " + secondPoint + " ; " + thirdPoint + " with an area of " + getArea();
    }


}
