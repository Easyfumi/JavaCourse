package ru.marinin.people;

public class Save {
    private Student student;

    public Save(Student student) {
        this.student = student;
    }

    public Student getSave() {
        return student;
    }

    public String toString() {
        return "SAVE: " + student.getName() + ": " + student.getGrades();
    }
}
