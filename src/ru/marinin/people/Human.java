package ru.marinin.people;

public class Human {
    private final FullName fullName;
    private int height;
    private Human father;

    public int getHeight() {
        return height;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Human getFather() {
        if (father!=null) {
            return new Human(father.fullName, father.height);
        }
        return null;
    }

    public void setHeight(int height) {
        if (height>0 && height<=500) {
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Human(FullName fullName, int height) {
        if (height>0 && height<=500) {
            this.fullName=fullName;
            this.height=height;
        } else {
            throw new IllegalArgumentException();
        }

    }
    public Human(String firstName, int height) {
        this(new FullName(firstName), height);
    }
    public Human(String firstName, int height, Human father) {
        this(new FullName(firstName, father.fullName.firstName+"ович", father.fullName.lastName), height);
        this.father=father;
    }
    public Human(FullName fullName, int height, Human father) {
        this(new FullName(fullName.firstName,
                        fullName.patronymic.isEmpty() ? father.fullName.firstName+"ович" : fullName.patronymic,
                        fullName.lastName.isEmpty() ? father.fullName.lastName : fullName.lastName),
                height);
        this.father=father;

    }

    @Override
    public String toString() {
        return "Имя:  " + fullName + ", рост: " + height + ".";
    }
}
