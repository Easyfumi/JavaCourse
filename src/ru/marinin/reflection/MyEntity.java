package ru.marinin.reflection;

import ru.marinin.reflection.annotations.ToString;
import ru.marinin.reflection.annotations.Validate;

@Validate(MyEntityTests.class)
@ToString(NeedToString.NO)
public class MyEntity extends Entity {
    private String str1 = "s1";
    private int ent1 = 1;

    public int getEnt1() {
        return ent1;
    }

    public String getStr1() {
        return str1;
    }
}
