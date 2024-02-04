package ru.marinin.people;

public class Builder {
    public  String name;
    public  String famName;
    public  String fatherName;

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public Builder setFamName(String famName) {
        this.famName = famName;
        return this;
    }

    public Builder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public Name build() {
        return new Name(name, famName, fatherName);
    }
}
