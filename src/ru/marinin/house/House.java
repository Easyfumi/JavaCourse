package ru.marinin.house;

public class House {
    private final int n;

    public House(int n) {
        if (n<=0) throw new IllegalArgumentException();
        this.n=n;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        if (n%10==1 && n!=11) {
            return "дом с " + n + " этажом";
        }
        return "дом с " + n + " этажами";
    }
}