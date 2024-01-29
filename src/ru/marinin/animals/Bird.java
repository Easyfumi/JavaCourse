package ru.marinin.animals;

public abstract class
Bird {
    protected final String song;
    public Bird(String song) {
        this.song=song;
    }
    public String sing() {
        return song;
    }

}
