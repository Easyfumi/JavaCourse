package ru.marinin.animals;

public class CatWrapper implements Meowable{
    public Meowable meowable;
    public int count;

    public CatWrapper(Meowable cat) {
        this.meowable = cat;
    }

    @Override
    public void meow() {
        meowable.meow();
        count++;
    }
}
