package ru.marinin.geometry;

import java.util.ArrayList;
import java.util.List;

public class Group implements Moveable {

    List<Moveable> list;

    private Group(Moveable... moveables) {
        list = new ArrayList<>(List.of(moveables));
    }

    public static Group of(Moveable... moveables) {
        return new Group(moveables);
    }

    @Override
    public void move(int x, int y) {
        for (Moveable moveable  : list) {
            moveable.move(x,y);
        }
    }

    @Override
    public String toString() {
        return "Group:\n" +
                list +
                "\n";
    }
}
