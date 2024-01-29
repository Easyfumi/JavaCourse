package ru.marinin.entities;


public class Storage<T> {
    private final T obj;

    private Storage(T obj) {
        this.obj = obj;
    }

    public static<V> Storage<V> create(V obj) {
        return new Storage<>(obj);
    }

    public T getObj(T defaultObj) {
        if (obj==null) {
            return defaultObj;
        }
        return obj;
    }
}
