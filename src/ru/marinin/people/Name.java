package ru.marinin.people;

public class Name {
    final String name, famName, FatherName;

    public Name(String name, String famName, String fatherName) {
        this.name = name;
        this.famName = famName;
        FatherName = fatherName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", famName='" + famName + '\'' +
                ", FatherName='" + FatherName + '\'' +
                '}';
    }

}
