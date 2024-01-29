package ru.marinin.animals;

public class CatDog extends Dog implements Meowable{
    Meowable meowable;
    Dog dog;
    public CatDog(Dog dog, Meowable meowable) {
        super(dog.name);
        this.meowable=meowable;
        this.dog=dog;
    }

    @Override
    public void meow() {
        meowable.meow();
    }
    @Override
    public void bark() {
        dog.bark();
    }
}
