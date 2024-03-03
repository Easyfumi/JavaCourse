package ru.marinin.reflection;

import ru.marinin.reflection.annotations.ToString;


public class EntityTest3 extends EntityTest2{
    private String str3 = "s3";
    @ToString(NeedToString.NO)
    private int ent3 = 3;
}
