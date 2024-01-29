package ru.marinin.entities;

public class Box<T> {
    private T obj;

    public T getObj() {
        T returningObj = obj;
        obj = null;
        return returningObj;
    }

    public void setObj(T obj) {
        if (checkBox()) {
            this.obj = obj;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkBox() {
        return this.obj==null;
    }
}
