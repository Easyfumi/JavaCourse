package ru.marinin.Trafficlight;

public enum Colors implements Color{

    GREEN("green"), RED("red");
    static {
        GREEN.next=RED;
        RED.next=GREEN;
    }

    public  String name;
    public  Colors next;

    private Colors(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }

    @Override
    public Colors next() {
        return next;
    }
}
