package ru.marinin.geometry;


import java.util.Objects;

public class Line<T extends Point> implements Polylineable, Cloneable, Lengthable {
    private T start;
    private T end;

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public T getStart() {
        return (T) start.clone();
    }

    public void setStart(T start) {
        this.start = (T) start.clone();
    }

    public T getEnd() {
        return (T) end.clone();
    }

    public void setEnd(Point end) {
        this.end = (T) end.clone();
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(getStart(), getEnd());
    }

    @Override
    public Line clone(){
        try {
            Line line = (Line) super.clone();
            line.start = start.clone();
            line.end = end.clone();
            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }


    public int length() {
        return this.start.length(this.end);
    }
}

