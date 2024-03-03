package ru.marinin;

import ru.marinin.reflection.MyEntity;
import ru.marinin.reflection.Validator;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity();
        Validator.validate(myEntity);
    }
}


