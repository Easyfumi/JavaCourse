package ru.marinin.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosedPolyline extends Polyline {
    public ClosedPolyline(Point... points) {
        super(points);
        super.addNewPoints(points[0]);
    }

    @Override
    public void addNewPoints(Point... points) {
        List<Point> list = this.getPoitns();
        list.remove(list.size()-1);
        list.addAll(Arrays.asList(points));
        list.add(list.get(0));
        this.setPoitns(list);
    }
}
