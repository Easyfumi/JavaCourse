package ru.marinin.animals;

public class CatWrapperII implements Meowable{
    public Meowable meowable;

    public CatWrapperII(Meowable cat) {
        this.meowable = cat;
    }

    @Override
    public void meow() {
        System.out.println("ВНИМАНИЕ");
        meowable.meow();
    }
}
