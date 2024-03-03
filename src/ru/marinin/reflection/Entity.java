package ru.marinin.reflection;
import java.lang.reflect.Field;
import java.util.*;

public abstract class Entity {

    @Override
    public final String toString() {
        List<Field> list = new ArrayList<>(Methods.feildCollection(this));

        Map<String, String> fieldsMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            try {
                list.get(i).setAccessible(true);
                fieldsMap.put(list.get(i).getName(), list.get(i).get(this)+"");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return this.getClass().getName() + fieldsMap.toString();
    }
}
