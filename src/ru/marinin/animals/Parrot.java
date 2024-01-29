package ru.marinin.animals;

import ru.marinin.animals.Bird;

public class Parrot extends Bird {
    public Parrot(String song) {
        super(song);
    }

    @Override
    public String sing() {
        byte[] byteArray = song.getBytes();
        int n = (int) (Math.random() * ((byteArray.length - 0) + 1)) + 0;
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n; i++) {
            str.append((char)byteArray[i]);
        }
        return str.toString();
    }
}
