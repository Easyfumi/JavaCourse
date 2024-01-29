package ru.marinin.geometry;

import java.util.Objects;

public class Point implements Cloneable {
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int length(Object point) {
        int katet1 = ((Point)point).x - this.x;
        int katet2 = ((Point)point).y - this.y;
        int length = (int) Math.sqrt(Math.pow(katet1, 2) + Math.pow(katet2, 2));
        return length;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }


}