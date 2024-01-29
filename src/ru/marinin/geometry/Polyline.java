package ru.marinin.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Polyline<T extends Point> implements Polylineable, Moveable {

    private List<T> poitns;

    public Polyline(T... points) {
        this.poitns = new ArrayList<>(Arrays.asList(points));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polyline polyline = (Polyline) o;
        return Objects.equals(poitns, polyline.poitns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(poitns);
    }

    private Point[] toArray(List<T> list) {
        Point[] pointsArray = new Point[list.size()];
        for (int i=0; i<list.size(); i++) {
            pointsArray[i]=list.get(i);
        }
        return pointsArray;
    }

    public List<T> getPoitns() {
        return new ArrayList<>(poitns);
    }

    public void setPoitns(List<T> poitns) {
        this.poitns = new ArrayList<>(poitns);
    }



    public int length() {
        int sum = 0;
        if (poitns.size()>1) {
            for (int i=1; i<poitns.size(); i++) {
                sum += new Line(poitns.get(i-1), poitns.get(i)).length();
            }
            return sum;
        }
        return 0;
    }

    public void addNewPoints(T... points) {
        List<T> newPoints = new ArrayList<>(Arrays.asList(points));
        this.poitns.addAll(newPoints);
    }

    @Override
    public String toString() {
        return "Polyline with point:  " + poitns;
    }

    @Override
    public Polyline getPolyline() {
        return this;
    }

    @Override
    public void move(int x, int y) {
        for (T t:poitns) {
            t.move(x, y);
        }
    }
}