package ru.marinin.reflection;


import ru.marinin.reflection.annotations.ToString;

public class EntityTest2 extends EntityTest1 {
    @ToString(NeedToString.NO)
    private String str2 = "s2";
    private int ent2 = 2;
}
