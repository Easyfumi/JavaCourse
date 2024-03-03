package ru.marinin.reflection;

@Annotations.Two(first = "first", second = 1)
public class EntityTest1 extends Entity {
    @Annotations.Default(String.class)
    @Annotations.ToString()
    private String str1 = "string from entity test 1";
    public int entityCount1 = 1;
    private int test;

    public EntityTest1() {
        test = 10;
    }


    @Annotations.Invoke
    public int sum() {
        return entityCount1 + 10;
    }
}
