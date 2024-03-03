package ru.marinin;

import ru.marinin.reflection.MyEntity;
import ru.marinin.reflection.Validator;
import ru.marinin.reflection.reflectionUtils;

import java.io.InvalidObjectException;

public class Main {
    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity();
        System.out.println(reflectionUtils.collect(MyEntity.class));
    }
}


