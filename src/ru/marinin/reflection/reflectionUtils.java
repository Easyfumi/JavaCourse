package ru.marinin.reflection;

import ru.marinin.geometry.Line;
import ru.marinin.geometry.Point;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reflectionUtils {
    public static List feildCollection(Object object) {

        List<Class> list = new ArrayList<>();
        List<Field> fieldList = new ArrayList<>();

        Class tmp = object.getClass();
        list.add(tmp);

        while (!tmp.getSimpleName().equals("Object")) {
            tmp = tmp.getSuperclass();
            list.add(tmp);
        }

        for (Class clz : list) {
            fieldList.addAll(Arrays.asList(clz.getDeclaredFields()));
        }

        return fieldList;
    }


    public static<T extends Point> void lineConnector(Line<T> line1, Line<T> line2) {
        try {
            Field fieldStart = line2.getClass().getDeclaredField("start");
            Field fieldEnd = line1.getClass().getDeclaredField("end");
            fieldEnd.setAccessible(true);
            fieldStart.setAccessible(true);
            fieldStart.set(line2, fieldEnd.get(line1));
        } catch (NoSuchFieldException e) {
            System.out.println("ne nashol");
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            System.out.println("ne zamenil");
            throw new RuntimeException(e);
        }
    }
}
