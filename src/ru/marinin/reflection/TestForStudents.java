package ru.marinin.reflection;

import ru.marinin.people.Student;

public class TestForStudents {
    public void test1(Student student) {
        if (student.getName()==null) {
            System.out.println("test1 error");
        //    throw new AssertionError();
        }
    }

    public void test2(Student student) {
        if (student.getGrades().size()==0) {
            System.out.println("test2 error");
        //    throw new AssertionError();
        }
    }
}
