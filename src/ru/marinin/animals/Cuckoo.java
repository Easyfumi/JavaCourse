package ru.marinin.animals;

import ru.marinin.animals.Bird;

public class Cuckoo extends Bird {
    public Cuckoo() {
        super("ку-ку");
    }
    @Override
    public String sing() {
        int n = (int) (Math.random() * ((10 - 0) + 1)) + 0;
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n; i++) {
            str.append(song +  " ");
        }
        return str.toString().trim();
    }
}
