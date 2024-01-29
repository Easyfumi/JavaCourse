package ru.marinin.animals;

public class DogVoice implements Meowable{
    Dog dog;

    public DogVoice(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void meow() {
        dog.bark();
    }
}
