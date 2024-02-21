package ru.marinin.work;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Entity {

    @Override
    public String toString() {
        Field[] field = this.getClass().getFields();

        Map<String, String> fieldsMap = new HashMap<>();
        for (int i = 0; i < field.length; i++) {
            try {
                field[i].setAccessible(true);
                fieldsMap.put(field[i].getName(), field[i].get(this)+"");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return this.getClass().getName() + fieldsMap.toString();
    }
}
