package ru.marinin.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Compare{
    String name;
    List<Integer> grades;

    public Student(String name, Integer... args) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(args));
    }

    public double getMiddleGrade() {
        int sum = 0;
        if (grades.isEmpty())
            return 0;
        for (int i=0; i<grades.size(); i++) {
            sum += grades.get(i);
        }
        return (double) sum/grades.size();
    }

    public boolean isExcellentStudent() {
        if (this.grades.isEmpty())
            return false;
        if (this.grades.contains(1) || this.grades.contains(2) || this.grades.contains(3) || this.grades.contains(4))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + grades;
    }

    @Override
    public int compare(Object obj) {
        double diff = this.getMiddleGrade() - ((Student) obj).getMiddleGrade();
        if (diff>0) return 1;
        if (diff<0) return -1;
        return 0;
    }
}