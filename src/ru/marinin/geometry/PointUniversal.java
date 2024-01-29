package ru.marinin.geometry;

import java.util.ArrayList;
import java.util.List;

public class PointUniversal {
    private List<Attribute> list = new ArrayList<>();
    public void addAttribute(String name, Object value) {
        list.add(new Attribute(name, value));
    }

    public Object getAttribute(String name) {
        for (Attribute at : list) {
            if (at.name.equals(name)) return at.value;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        for (Attribute at : list) {
            st.append(at.name + ": " + at.value +"\n");
        }
        return st.toString();
    }

}

class Attribute {
    String name;
    Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}
