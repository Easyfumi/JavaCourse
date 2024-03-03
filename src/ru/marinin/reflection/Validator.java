package ru.marinin.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Validator {
    public static void validate(Object objectForTest, Class testerClass) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor cstr = testerClass.getDeclaredConstructors()[0];
        Object testerObject = cstr.newInstance();
        Method[] tests = testerClass.getDeclaredMethods();
        for (Method test : tests) {
            test.invoke(testerObject, objectForTest);
        }
    }
}
